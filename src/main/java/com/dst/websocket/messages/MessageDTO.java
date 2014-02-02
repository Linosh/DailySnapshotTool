package com.dst.websocket.messages;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public class MessageDTO {
	private MessageType messageType;
	private String body;
	private String id;

	public MessageDTO(MessageType messageType, String body, String id) {
		this.messageType = messageType;
		this.body = body;
		this.id = id;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public String getBody() {
		return body;
	}

	public String getId() {
		return id;
	}
}
