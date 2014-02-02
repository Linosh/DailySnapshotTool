package com.dst.websocket.messages;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Keeps all message types. As typeNames used fields names for income json objects
 */
public enum MessageType {

	//Unknown type
	NONE("none"),

	// Record related types
	RECORD_GET_TYPES("getTypes"),
	RECORD_SAVE("save"),
	RECORD_REMOVE("remove"),

	//general
	INFO("info"),

	// Feedback on save/remove operations etc...
	SUCCESS("success"),
	ERROR("error");

	private String typeName;

	private MessageType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public static MessageType parse(String action) {
		for (MessageType a : values()) {
			if (a.getTypeName().equals(action)) {
				return a;
			}
		}

		return NONE;
	}
}
