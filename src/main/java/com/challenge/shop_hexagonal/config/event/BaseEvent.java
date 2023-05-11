package com.challenge.shop_hexagonal.config.event;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.ToString;

@ToString
public class BaseEvent {
	protected final long timestamp;

	public BaseEvent() {
		this.timestamp = System.currentTimeMillis();
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getDate() {
		Date date = new Date(new Timestamp(timestamp).getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return format.format(date);
	}
}