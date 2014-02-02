package com.dst.websocket.rpc.request.processors;

import com.dst.websocket.messages.MessageType;
import com.dst.websocket.rpc.request.processors.impl.RecordTypesMsgProc;
import com.dst.websocket.rpc.request.processors.impl.RemRecMsgProc;
import com.dst.websocket.rpc.request.processors.impl.SaveRecMsgProc;
import com.dst.websocket.rpc.request.processors.impl.UnkMsgTypeProc;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Resolves processor by message type. Hides implementation.
 */
public class ProcessorsFactory {
	public static JsonMsgProcessor getProcessor(final MessageType msgType) {
		switch (msgType) {
			case RECORD_GET_TYPES:
				return new RecordTypesMsgProc();
			case RECORD_SAVE:
				return new SaveRecMsgProc();
			case RECORD_REMOVE:
				return new RemRecMsgProc();
			default:
				return new UnkMsgTypeProc();
		}
	}
}
