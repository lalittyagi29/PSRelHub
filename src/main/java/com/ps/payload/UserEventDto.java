package com.ps.payload;

public class UserEventDto {

	private String eventId;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public UserEventDto(String eventId) {
		super();
		this.eventId = eventId;
	}

	public UserEventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
