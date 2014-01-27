package com.dst.web.websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 1/28/14
 */
@ServerEndpoint(value = "/echo")
public class EchoEndpointAnnotated {
	@OnMessage
	public String onMessage(String message, Session session) {
		return message;
	}
}