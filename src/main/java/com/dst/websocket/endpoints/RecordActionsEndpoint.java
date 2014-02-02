package com.dst.websocket.endpoints;

import com.dst.eventbus.EventBusContext;
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
	public void sendMessage(String msg) throws IOException{
		this.session.getBasicRemote().sendText(msg);
	}

	@OnMessage
	public String onMsg(String message) {
		return message + " (from your server)";
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