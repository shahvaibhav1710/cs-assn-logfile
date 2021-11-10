package com.suisse.credit.models;

public class Record {

	public String id;
	public String type;
	public String host;
	public String state;
	public long timestamp;
	public boolean alert;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", type=" + type + ", host=" + host + ", state=" + state + ", timestamp="
				+ timestamp + ", alert=" + alert + "]";
	}
	
}
