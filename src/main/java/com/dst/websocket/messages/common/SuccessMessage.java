package com.dst.websocket.messages.common;

import com.dst.websocket.messages.AbstractJsonMessage;
import com.dst.websocket.messages.MessageType;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Defines simple 200 OK message on any POST-like request
 */
public class SuccessMessage extends AbstractJsonMessage<SuccessMessage> {

	@Override
	protected MessageType getType() {
		return MessageType.SUCCESS;
	}

	@Override
	protected String getBody() {
		return "OK";
	}

	@Override
	protected SuccessMessage parseBody(String body) {
		return new SuccessMessage();
	}
}
