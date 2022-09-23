package com.ps.payload;

import java.util.List;

public class UserDto {

	private String id;
	private String name;
	private String email;
	private String profilePictureUrl;
	private String VolunteerHour;
	private String moneyDonated;
	private String Location;
	private String bio;
	private List<GoalDto> currentGoal;
	private List<GoalDto> pastGoal;
	private List<UserEventDto> bookmarkEvent;
	private int totalGoal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public String getVolunteerHour() {
		return VolunteerHour;
	}

	public void setVolunteerHour(String volunteerHour) {
		VolunteerHour = volunteerHour;
	}

	public String getMoneyDonated() {
		return moneyDonated;
	}

	public void setMoneyDonated(String moneyDonated) {
		this.moneyDonated = moneyDonated;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<GoalDto> getCurrentGoal() {
		return currentGoal;
	}

	public void setCurrentGoal(List<GoalDto> currentGoal) {
		this.currentGoal = currentGoal;
	}

	public List<GoalDto> getPastGoal() {
		return pastGoal;
	}

	public void setPastGoal(List<GoalDto> pastGoal) {
		this.pastGoal = pastGoal;
	}

	public List<UserEventDto> getBookmarkEvent() {
		return bookmarkEvent;
	}

	public void setBookmarkEvent(List<UserEventDto> bookmarkEvent) {
		this.bookmarkEvent = bookmarkEvent;
	}

	public int getTotalGoal() {
		return totalGoal;
	}

	public void setTotalGoal(int totalGoal) {
		this.totalGoal = totalGoal;
	}

	public UserDto(String id, String name, String email,  String profilePictureUrl,
			String volunteerHour, String moneyDonated, String location, String bio, List<GoalDto> currentGoal,
			List<GoalDto> pastGoal, List<UserEventDto> bookmarkEvent, int totalGoal) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.profilePictureUrl = profilePictureUrl;
		VolunteerHour = volunteerHour;
		this.moneyDonated = moneyDonated;
		Location = location;
		this.bio = bio;
		this.currentGoal = currentGoal;
		this.pastGoal = pastGoal;
		this.bookmarkEvent = bookmarkEvent;
		this.totalGoal = totalGoal;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
