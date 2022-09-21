package com.ps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.Exception.ResourceNotFoundException;
import com.ps.model.User;
import com.ps.payload.GoalDto;
import com.ps.payload.UserEventDto;
import com.ps.repository.NewUserRepo;
import com.ps.utilty.PSUId;
import com.ps.utilty.PSVaraible;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private NewUserRepo newUserRepo;

	@Override
	public User createUser(User user) {
		String uniqueId = PSUId.getUniqueId(PSVaraible.USER_MODEL);
		Optional<User> UserById = this.newUserRepo.findById(uniqueId);
		if (UserById.isEmpty()) {
			user.setId(uniqueId);
		} else {
			createUser(user);
		}
		List<GoalDto> byDefaultGoallist = new ArrayList<>();
		List<UserEventDto> byDefaultUserEventlist = new ArrayList<>();
		user.setBookmarkEvent(byDefaultUserEventlist);
		user.setCurrentGoal(byDefaultGoallist);
		user.setPastGoal(byDefaultGoallist);
		user.setVolunteerHour("0");
		user.setMoneyDonated("100$");
		user.setProfilePictureUrl("blank");
		User save = this.newUserRepo.save(user);
		return save;
	}

	@Override
	public User updateBasicProfile(User user, String userId) {
		User currentUserDetails = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		if (user.getName() != null) {
			currentUserDetails.setName(user.getName());
		}
		if (user.getLocation() != null) {
			currentUserDetails.setLocation(user.getLocation());
		}
		if (user.getBio() != null) {
			currentUserDetails.setBio(user.getBio());
		}
		return this.newUserRepo.save(currentUserDetails);
	}

	@Override
	public User updateEventList(String userId, String eventId) {
		UserEventDto userEventDto = new UserEventDto();
		userEventDto.setEventId(eventId);
		User userDetails = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		List<UserEventDto> userEventDtos = userDetails.getBookmarkEvent();
		Boolean isAlreadyExist = false;
		for (UserEventDto bookMarkEvent : userEventDtos) {
			if (bookMarkEvent.getEventId().equals(eventId)) {
				isAlreadyExist = true;
			}
		}

		if (isAlreadyExist == false) {
			userEventDtos.add(userEventDto);
			userDetails.setBookmarkEvent(userEventDtos);
			return this.newUserRepo.save(userDetails);
		} else {
			return userDetails;
		}

	}

	@Override
	public User unBookmarkEvent(String userId, String eventId) {
		User userDetails = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		List<UserEventDto> bookmarkEvents = userDetails.getBookmarkEvent();
		for (int i = 0; i < bookmarkEvents.size(); i++) {
			UserEventDto bookmarkevent = bookmarkEvents.get(i);
			if (bookmarkevent.getEventId().equals(eventId)) {
				bookmarkEvents.remove(bookmarkevent);
				break;
			}
		}
		userDetails.setBookmarkEvent(bookmarkEvents);
		return this.newUserRepo.save(userDetails);
	}

	@Override
	public User getUserById(String userId) {
		User user = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		return user;
	}

	@Override
	public List<User> getAllUSer() {
		return this.newUserRepo.findAll();
	}

	@Override
	public String deleteUserProfile(String userId) {
		try {
			this.newUserRepo.deleteById(userId);
			return "Suceess!!";
		} catch (Exception e) {
			return "Error!!";
		}
	}

	@Override
	public User addGoal(GoalDto goalDto, String userId) {
		User userProfile = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		List<GoalDto> currentGoal = userProfile.getCurrentGoal();
		String uniqueId = PSUId.getUniqueId(PSVaraible.GOAL_MODEL);
		Boolean isPresent = false;
		for (GoalDto goal : currentGoal) {
			if (goal.getId().equals(uniqueId)) {
				isPresent = true;
				break;
			}
		}
		if (isPresent == false) {
			goalDto.setId(uniqueId);
		} else {
			addGoal(goalDto, userId);
		}
		currentGoal.add(goalDto);
		userProfile.setCurrentGoal(currentGoal);
		return this.newUserRepo.save(userProfile);
	}

	@Override
	public User completedGoal(String userId, String goalId) {
		User userProfile = this.newUserRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
		List<GoalDto> pastGoal = userProfile.getPastGoal();
		List<GoalDto> currentGoal = userProfile.getCurrentGoal();
		for (int i = 0; i < currentGoal.size(); i++) {
			GoalDto goalDto = currentGoal.get(i);
			if (goalDto.getId().equals(goalId)) {
				pastGoal.add(goalDto);
				currentGoal.remove(goalDto);
				break;
			}
		}
		userProfile.setPastGoal(pastGoal);
		userProfile.setCurrentGoal(currentGoal);
		return this.newUserRepo.save(userProfile);
	}

}
