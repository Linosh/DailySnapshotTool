/**
 * Handmade RPC util for managing callbacks from server. Because Web Sockets is very low-level stuff to manage such things.
 * Instance keeps connection for each page's part on which it was created until page reloaded.
 *
 * @param WS_CONNECT_URL ws connection url
 * @constructor
 */
function WsRPC(WS_CONNECT_URL) {

	// keeps ws connection
	var wsConn = new WebSocket(WS_CONNECT_URL);

	// defines onMessage function with calling proper callback from pool
	wsConn.onmessage = function (msg) {

		// parsing income json msg
		var msgObj = Global.parseJsonString(msg.data)
		if (msgObj == null) {
			return;
		}

		// looking for needed callback by msg id
		var executor = RPCExecutorPool.getById(msgObj.id)
		if (executor != undefined) {
			executor.onSuccess(msgObj);
		}
	};

	// defines RPC call method for sending request to server
	this.call = function (reqObj, onSuccess) {
		var executor = new RPCExecutor(Global.createUUID(), reqObj, onSuccess);
		executor.execute(wsConn);
	};

	// defines pool of executors. similar to map where key is unique message id
	var RPCExecutorPool = {
		valsMap: {},

		add: function (lsnr) {
			this.valsMap[lsnr.id] = lsnr;
		},

		remove: function (lsnr) {
			delete this.valsMap[lsnr.id];
		},

		getById: function (id) {
			return this.valsMap[id]
		}
	};

	// responsible for sending message and applying callback in case of response
	function RPCExecutor(id, reqObj, onSuccess) {
		var self = this;

		this.id = id;
		this.requestObj = reqObj;

		this.onSuccess = function (msgObj) {

			if (msgObj.id == self.id) {
				delete msgObj.id;
				onSuccess(msgObj);
			}

			RPCExecutorPool.remove(this);
		};

		this.execute = function (wsConn) {
			RPCExecutorPool.add(this);

			self.requestObj.id = self.id;
			wsConn.send($.toJSON(self.requestObj));
		}
	}
}