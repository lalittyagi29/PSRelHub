package com.ps.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ps.payload.GoalDto;

@Document(collection = "USERDATA")
public class User {

	@Id
	private String id;
	private String namee;
	private String email;
	private String password;
	private String profilePictureUrl;
	private String VolunteerHour;
	private String moneyDonated;
	private String Location;
	private String bio;
	private List<String> eventId;
	private List<GoalDto> currentGoal;
	private List<GoalDto> pastGoal;

	public User(String id, String namee, String email, String password, String profilePictureUrl, String volunteerHour,
			String moneyDonated, String location, String bio, List<String> eventId, List<GoalDto> currentGoal,
			List<GoalDto> pastgoal) {
		super();
		this.id = id;
		this.namee = namee;
		this.email = email;
		this.password = password;
		this.profilePictureUrl = profilePictureUrl;
		VolunteerHour = volunteerHour;
		this.moneyDonated = moneyDonated;
		Location = location;
		this.bio = bio;
		this.eventId = eventId;
		this.currentGoal = currentGoal;
		this.pastGoal = pastgoal;
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

	public String getNamee() {
		return namee;
	}

	public void setNamee(String namee) {
		this.namee = namee;
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

	public List<String> getEventId() {
		return eventId;
	}

	public void setEventId(List<String> eventId) {
		this.eventId = eventId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
