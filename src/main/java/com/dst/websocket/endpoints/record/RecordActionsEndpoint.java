package com.dst.websocket.endpoints.record;

import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.MessageDTO;
import com.dst.websocket.pubsub.eventbus.EventBusContext;
import com.dst.utils.JsonUtils;
import com.dst.websocket.messages.record.RecordTypesMessage;
import com.dst.websocket.rpc.request.processors.JsonMsgProcessor;
import com.dst.websocket.rpc.request.processors.ProcessorsFactory;
import com.google.common.eventbus.Subscribe;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 1/28/14
 */
@ServerEndpoint(value = "/records")
public class RecordActionsEndpoint {
	private Session session;

	@OnOpen
	public void onOpen(Session session) throws IOException {
		this.session = session;
		EventBusContext.registerListener(this);
		session.getBasicRemote().sendText("Connection opened");
	}

	@Subscribe
	public void sendMessage(RecordTypesMessage msg) throws IOException {
		this.session.getBasicRemote().sendText(msg.toJson());
	}

	@OnMessage
	public String onMsg(String message) {
		MessageDTO dto = JsonUtils.fromJson(message);
		JsonMsgProcessor proc = ProcessorsFactory.getProcessor(dto.getMessageType());
		JsonMessage msg = proc.apply(dto.getBody());
		return msg.toJson(dto.getId());
	}

	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		EventBusContext.unregisterListener(this);
	}
}