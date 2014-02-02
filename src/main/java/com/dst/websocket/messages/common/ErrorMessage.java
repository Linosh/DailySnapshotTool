package com.dst.websocket.messages.common;

import com.dst.websocket.messages.AbstractJsonMessage;
import com.dst.websocket.messages.MessageType;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Defines simple error message on any GET/POST-like request with simple text inside
 */
public class ErrorMessage extends AbstractJsonMessage<ErrorMessage> {

	private String errorMessageText;

	public ErrorMessage() {
	}

	public ErrorMessage(String errorMessageText) {
		this.errorMessageText = errorMessageText;
	}

	@Override
	protected ErrorMessage parseBody(String body) {
		return new ErrorMessage(body);
	}

	@Override
	public MessageType getType() {
		return MessageType.ERROR;
	}

	@Override
	public String getBody() {
		return errorMessageText;
	}
}
