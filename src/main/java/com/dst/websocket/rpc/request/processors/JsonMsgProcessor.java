package com.dst.websocket.rpc.request.processors;

import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.MessageDTO;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public interface JsonMsgProcessor {
	JsonMessage apply(String msgBody);
}
