package com.dst.websocket.messages.common;

import com.dst.websocket.messages.AbstractJsonMessage;
import com.dst.websocket.messages.MessageType;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Defines simple message for hidden updates from server side to client listeners.
 * Will be used in pubsub via EvenBus logic
 */
public class InfoMessage extends AbstractJsonMessage <InfoMessage> {

	private String infoMessageText;

	public InfoMessage(String infoMessageText) {
		this.infoMessageText = infoMessageText;
	}

	@Override
	protected MessageType getType() {
		return MessageType.INFO;
	}

	@Override
	protected String getBody() {
		return infoMessageText;
	}

	@Override
	protected InfoMessage parseBody(String body) {
		return new InfoMessage(body);
	}
}
