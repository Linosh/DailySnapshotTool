package com.dst.websocket.pubsub.eventbus;

import com.google.common.eventbus.EventBus;
import org.apache.log4j.Logger;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 1/29/14
 */
public class EventBusContext {
	private static final Logger LOGGER = Logger.getLogger(EventBusContext.class);

	private EventBusContext() {}

	private static final EventBus EVENT_BUS = new EventBus("DAILY_SNAPSHOT_TOOL");

	public static void registerListener(Object o) {
		if (o == null) {
			LOGGER.error("Listener object is NULL");
			return;
		}

		LOGGER.info("Registering event listener: " + o.getClass().getSimpleName());

		EVENT_BUS.register(o);
	}

	public static void unregisterListener(Object o) {
		if (o == null) {
			LOGGER.error("Listener object is NULL");
			return;
		}

		LOGGER.info("Unregistering event listener: " + o.getClass().getSimpleName());

		EVENT_BUS.unregister(o);
	}

	public static void postEvent(Object event) {

		if (event == null) {
			LOGGER.error("Event object is NULL");
			return;
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Post event: " + event.getClass().getSimpleName());
		}

		EVENT_BUS.post(event);
	}
}
