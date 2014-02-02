package com.dst.websocket.messages;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Keeps main info re request/response between client and server. Designed as Immutable object
 */
public class MessageDTO {
	/**
	 * Type of request/response
	 */
	private MessageType messageType;

	/**
	 * Body of request/response
	 */
	private String body;

	/**
	 * Id of request/response. For RPC purposes
	 */
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
