package com.dst.websocket.rpc.request.processors.impl;

import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.common.SuccessMessage;
import com.dst.websocket.rpc.request.processors.JsonMsgProcessor;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public class RemRecMsgProc implements JsonMsgProcessor {

	@Override
	public JsonMessage apply(String msgBody) {
		return new SuccessMessage();
	}
}
