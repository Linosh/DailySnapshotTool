package com.dst.websocket.endpoints.record;

import com.dst.utils.JsonUtils;
import com.dst.websocket.messages.JsonMessage;
import com.dst.websocket.messages.MessageDTO;
import com.dst.websocket.messages.record.RecordTypesMessage;
import com.dst.websocket.pubsub.eventbus.EventBusContext;
import com.dst.websocket.rpc.request.processors.JsonMsgProcessor;
import com.dst.websocket.rpc.request.processors.ProcessorsFactory;
import com.google.common.eventbus.Subscribe;
import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 1/28/14
 * <p/>
 * End point for managing requests re records actions
 */
@ServerEndpoint(value = "/records")
public class RecordActionsEndpoint {
	private static final Logger LOGGER = Logger.getLogger(RecordActionsEndpoint.class);

	/**
	 * Keep session as endpoint state to ability send async message fro server
	 * This is thread safe solution 'cause Web Socket spec guarantee that end point will be
	 * created for each connection
	 */
	private Session session;

	@OnOpen
	public void onOpen(Session session) throws IOException {
		//remembering session
		this.session = session;

		// registering message listener for catching messages form other pats of app
		EventBusContext.registerListener(this);
	}

	@Subscribe
	public void sendMessage(RecordTypesMessage msg) throws IOException {
		// sending message from event bus using saved session
		if (session != null && msg != null){
			this.session.getBasicRemote().sendText(msg.toJson());
		}
	}

	/**
	 * Responsible for resolving message processor by message type and passing through message id
	 * for supporting RPC approach from client side
	 * @param message
	 * @return
	 */
	@OnMessage
	public String onMsg(String message) {
		//converting income json text msg to DTO
		MessageDTO dto = JsonUtils.fromJson(message);

		// locking for appropriate processor by message type
		JsonMsgProcessor proc = ProcessorsFactory.getProcessor(dto.getMessageType());

		// applying processor on message body
		JsonMessage msg = proc.apply(dto.getBody());

		// send back response with attached message id for RPC purposes
		return msg.toJson(dto.getId());
	}

	@OnError
	public void onError(Throwable t) {
		LOGGER.error(t);
	}

	@OnClose
	public void onClose(Session session) {
		// Unregistering listener if session is closing
		EventBusContext.unregisterListener(this);
	}
}