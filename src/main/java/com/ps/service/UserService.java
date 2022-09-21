package com.ps.service;

import java.util.List;

import com.ps.model.User;
import com.ps.payload.GoalDto;

public interface UserService {

	User createUser(User user);

	User updateBasicProfile(User user, String userId);

	User updateEventList(String userId, String eventId);

	User getUserById(String userId);

	List<User> getAllUSer();

	String deleteUserProfile(String userId);

	User unBookmarkEvent(String userId, String eventId);
	
	User addGoal(GoalDto goalDto, String userId);
	
	User completedGoal(String userId,String goalId);
	
}
