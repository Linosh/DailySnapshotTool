package com.dst.websocket.rpc.request.processors;

import com.dst.websocket.messages.JsonMessage;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * General type for processor
 */
public interface JsonMsgProcessor {

	/**
	 * Apply some logic on message body and return JsonMessage as response on request
	 * @param msgBody json message body
	 * @return JsonMessage's instance
	 */
	JsonMessage apply(String msgBody);
}
