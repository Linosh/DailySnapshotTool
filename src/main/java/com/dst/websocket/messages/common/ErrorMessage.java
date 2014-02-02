package com.dst.websocket.messages.common;

import com.dst.websocket.messages.MessageType;
import com.dst.websocket.messages.AbstractJsonMessage;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
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
