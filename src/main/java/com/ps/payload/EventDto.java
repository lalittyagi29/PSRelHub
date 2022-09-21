package com.ps.payload;

public class EventDto {

	private String eventId;
	private String organiserName;
	private String causesTag;
	private String title;
	private String backgroundImgUrl;
	private String description;
	private String date;
	private String location;
	private String startTime;
	private String endTime;

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(String eventId, String organiserName, String causesTag, String title, String backgroundImgUrl,
			String description, String date, String location, String startTime, String endTime) {
		super();
		this.eventId = eventId;
		this.organiserName = organiserName;
		this.causesTag = causesTag;
		this.title = title;
		this.backgroundImgUrl = backgroundImgUrl;
		this.description = description;
		this.date = date;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getOrganiserName() {
		return organiserName;
	}

	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}

	public String getCausesTag() {
		return causesTag;
	}

	public void setCausesTag(String causesTag) {
		this.causesTag = causesTag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackgroundImgUrl() {
		return backgroundImgUrl;
	}

	public void setBackgroundImgUrl(String backgroundImgUrl) {
		this.backgroundImgUrl = backgroundImgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
