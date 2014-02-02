package com.dst.websocket.rpc.request.processors.impl;

import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.common.ErrorMessage;
import com.dst.websocket.rpc.request.processors.JsonMsgProcessor;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Returns in case of unknown message type
 */
public class UnkMsgTypeProc implements JsonMsgProcessor {

	@Override
	public JsonMessage apply(String msgBody) {
		return new ErrorMessage("Unknown message type");
	}
}
