package com.dst.utils;

import com.dst.websocket.messages.MessageDTO;
import com.dst.websocket.messages.MessageType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 *
 * Currently it's kinda facade for GSON in case of change it to smth else
 */
public class JsonUtils {

	public static final String MSG_TYPE_PARAM = "type";
	public static final String BODY_PARAM = "body";
	public static final String ID_PARAM = "id";

	/**
	 * According to spec it's thread safe
	 */
	private static Gson PARSER = new Gson();

	/**
	 * Util class should have private constructor
	 */
	private JsonUtils() {
	}

	/**
	 * Converts JSON string to DTO object
	 * @param json message string
	 * @return DTO object
	 */
	public static MessageDTO fromJson(String json) {
		Map<String, String> map = new HashMap();
		map = PARSER.fromJson(json, map.getClass());
		MessageType messageType = MessageType.parse(map.get(MSG_TYPE_PARAM));
		String body = map.get(BODY_PARAM);
		String id = map.get(ID_PARAM);
		return new MessageDTO(messageType, body, id);
	}

	/**
	 * Converts DTO to JSON message
	 * @param msg DTO object
	 * @return JSON string
	 */
	public static String toJson(MessageDTO msg) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(MSG_TYPE_PARAM, msg.getMessageType().getTypeName());
		jsonObject.addProperty(BODY_PARAM, msg.getBody());
		jsonObject.addProperty(ID_PARAM, msg.getId());
		return PARSER.toJson(jsonObject);
	}

	public static String toJson(List elems) {
		return PARSER.toJson(elems);
	}

	public static String toJson(String[] msg) {
		return PARSER.toJson(msg);
	}
}
