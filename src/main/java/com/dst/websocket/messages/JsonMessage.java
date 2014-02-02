package com.dst.websocket.messages;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public interface JsonMessage<T extends JsonMessage> {
	String toJson(String id);
	T fromJson(String json);
}
