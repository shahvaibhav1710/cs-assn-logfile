package com.suisse.credit.models;

public class EventRecord {

	public String id;
	public String type;
	public String host;
	public long duration;
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
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
	@Override
	public String toString() {
		return "EventRecord [id=" + id + ", type=" + type + ", host=" + host + ", duration="
				+ duration + ", alert=" + alert + "]";
	}
	
}
