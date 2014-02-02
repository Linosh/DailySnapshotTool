function WsRPC(WS_CONNECT_URL) {

	var wsConn = new WebSocket(WS_CONNECT_URL);
	wsConn.onmessage = function (msg) {
		var msgObj;

		try {
			msgObj= $.secureEvalJSON(msg.data);
		} catch(e) {
			console.warn(e)
			return;
		}

		var executor = RPCExecutorPool.getById(msgObj.id)
		if (executor != undefined) {
			executor.onSuccess(msgObj);
		}
	};

	this.call = function (reqObj, onSuccess) {
		var executor = new RPCExecutor(Global.createUUID(), reqObj, onSuccess);
		executor.execute(wsConn);
	};


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