package com.dst.orm.entities;

/**
 * Project: DailySnapshotTool
 * Author: Yermiichuk Dmitrii
 * Date: 2/2/14
 */
public class Record {
	private String recType;
	private String recMsg;
	private String recTime;

	public Record() {
	}

	public Record(String recType, String recMsg, String recTime) {
		this.recType = recType;
		this.recMsg = recMsg;
		this.recTime = recTime;
	}

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public String getRecMsg() {
		return recMsg;
	}

	public void setRecMsg(String recMsg) {
		this.recMsg = recMsg;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}
}
