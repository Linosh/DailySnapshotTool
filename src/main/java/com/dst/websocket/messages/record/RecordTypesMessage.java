package com.dst.websocket.messages.record;

import com.dst.utils.JsonUtils;
import com.dst.websocket.messages.MessageType;
import com.dst.websocket.messages.AbstractJsonMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public class RecordTypesMessage extends AbstractJsonMessage<RecordTypesMessage> {

	private List<String> recTypes;

	public RecordTypesMessage() {
		recTypes = new ArrayList();
	}

	public RecordTypesMessage(List<String> types) {
		this.recTypes = types;
	}

	@Override
	protected RecordTypesMessage parseBody(String body) {
		return null;
	}

	@Override
	public MessageType getType() {
		return MessageType.RECORD_GET_TYPES;
	}

	@Override
	public String getBody() {
		return JsonUtils.toJson(recTypes);
	}


}
