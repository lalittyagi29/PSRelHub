package com.ps.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ps.payload.GoalDto;
import com.ps.payload.UserEventDto;

@Document(collection = "USER_PROFILE_V1")
public class User {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String profilePictureUrl;
	private String VolunteerHour;
	private String moneyDonated;
	private String Location;
	private String bio;
	private List<GoalDto> currentGoal;
	private List<GoalDto> pastGoal;
	private List<UserEventDto> bookmarkEvent;

	public User(String id, String name, String email, String password, String profilePictureUrl, String volunteerHour,
			String moneyDonated, String location, String bio, List<String> eventId, List<GoalDto> currentGoal,
			List<GoalDto> pastgoal, List<UserEventDto> bookmarkEvent) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profilePictureUrl = profilePictureUrl;
		VolunteerHour = volunteerHour;
		this.moneyDonated = moneyDonated;
		Location = location;
		this.bio = bio;
		this.currentGoal = currentGoal;
		this.pastGoal = pastgoal;
		this.bookmarkEvent = bookmarkEvent;
	}

	public List<UserEventDto> getBookmarkEvent() {
		return bookmarkEvent;
	}

	public void setBookmarkEvent(List<UserEventDto> bookmarkEvent) {
		this.bookmarkEvent = bookmarkEvent;
	}

	public List<GoalDto> getPastGoal() {
		return pastGoal;
	}

	public void setPastGoal(List<GoalDto> pastGoal) {
		this.pastGoal = pastGoal;
	}

	public List<GoalDto> getCurrentGoal() {
		return currentGoal;
	}

	public void setCurrentGoal(List<GoalDto> currentGoal) {
		this.currentGoal = currentGoal;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
