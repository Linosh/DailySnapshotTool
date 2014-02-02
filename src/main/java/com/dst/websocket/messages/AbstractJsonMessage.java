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

	protected abstract MessageType getType();
	protected abstract String getBody();
	protected abstract T parseBody(String body);
}
