package com.dst.websocket.messages;

import com.dst.utils.JsonUtils;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public abstract class AbstractJsonMessage<T extends AbstractJsonMessage> implements JsonMessage<T> {

	@Override
	public String toJson(String id) {
		MessageDTO msg = new MessageDTO(getType(), getBody(), id);
		return JsonUtils.toJson(msg);
	}

	public String toJson() {
		return toJson("");
	}

	@Override
	public T fromJson(String json) {
		MessageDTO msg = JsonUtils.fromJson(json);
		return parseBody(msg.getBody());
	}

	/**
	 * Defines message type for income/outcome message
	 */
	protected abstract MessageType getType();

	/**
	 * Defines message body for outcome message
	 */
	protected abstract String getBody();

	/**
	 * Parsse message body for income message
	 */
	protected abstract T parseBody(String body);
}
