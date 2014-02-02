package com.dst.websocket.rpc.request.processors.impl;

import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.record.RecordTypesMessage;
import com.dst.websocket.rpc.request.processors.JsonMsgProcessor;

import java.util.Arrays;
import java.util.List;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Gets types of records. Currently mocked.
 */
public class RecordTypesMsgProc implements JsonMsgProcessor {

	@Override
	public JsonMessage apply(String msgBody) {
		List<String> types = Arrays.asList("Development", "Management", "Rare cases");
		JsonMessage resp = new RecordTypesMessage(types);
		return resp;
	}
}
