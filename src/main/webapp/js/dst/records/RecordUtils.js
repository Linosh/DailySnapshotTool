// keeps message types for request objects
MessageTypes = {
	NONE: "none",

	RECORD_GET_TYPES: "getTypes",
	RECORD_SAVE: "save",
	RECORD_REMOVE: "remove",

	SUCCESS: "success",
	ERROR: "error"
}

// keeps extendable base requests objects
RequestObjects = {
	GetRecordTypes: {type: MessageTypes.RECORD_GET_TYPES},
	SaveRecord: {type: MessageTypes.RECORD_SAVE},
	RemoveRecord: {type: MessageTypes.RECORD_REMOVE}
}

// keeps utils to work with records (saving/removing/updating etc...)
RecordUtils = {

	recordsRPC: new WsRPC(Global.getSpecificEndPoint("records")),

	getRecTypes: function(onSuccess) {
		this.recordsRPC.call(RequestObjects.GetRecordTypes, function(dataObj) {
			var bodyObj = Global.parseJsonString(dataObj.body);
			if (bodyObj != null) {
				onSuccess(bodyObj);
			}
		});
	},

	saveRecord: function(recDataObj, onSuccess) {
		if (typeof recDataObj == "object") {
			var requestObject = $.extend(RequestObjects.SaveRecord, recDataObj);
			this.recordsRPC.call(requestObject, function(dataObj){
				var bodyObj = Global.parseJsonString(dataObj.body);
				if (bodyObj != null) {
					onSuccess(bodyObj);
				}
			});
		}
	},

	removeRecord: function(recDataObj, onSuccess) {
		if (typeof recDataObj == "object") {
			var requestObject = $.extend(RequestObjects.RemoveRecord, recDataObj);
			this.recordsRPC.call(requestObject, function(dataObj){
				var bodyObj = Global.parseJsonString(dataObj.body);
				if (bodyObj != null) {
					onSuccess(bodyObj);
				}
			});
		}
	}
}