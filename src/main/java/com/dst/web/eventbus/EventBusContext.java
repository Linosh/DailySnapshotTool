package com.dst.web.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 1/29/14
 */
public class EventBusContext {
	private EventBusContext() {}

	private static final EventBus EVENT_BUS = new EventBus("DAILY_SNAPSHOT_TOOL");

	public static void registerListener(Object o) {
		EVENT_BUS.register(o);
	}

	public static void unregisterListener(Object o) {
		EVENT_BUS.unregister(o);
	}

	public static void postEvent(Object event) {
		EVENT_BUS.post(event);
	}
}
