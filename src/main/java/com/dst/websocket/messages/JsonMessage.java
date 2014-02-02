package com.dst.websocket.messages;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Basic JSON methods for sending messages from client to server and vise-versa.
 * All implementations should HIDE internal state.
 */
public interface JsonMessage<T extends JsonMessage> {
	String toJson(String id);
	T fromJson(String json);
}
