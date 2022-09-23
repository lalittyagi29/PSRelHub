package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.model.User;
import com.ps.payload.GoalDto;
import com.ps.payload.UserDto;
import com.ps.service.UserService;

@RestController
@RequestMapping("/v1/api/")
public class Controller {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	@ResponseBody
	public String Test(@RequestParam String a, @RequestParam String b) {
		return a + b;
	}
	
	@GetMapping("/testing")
	public String teststring() {
		return "Hosting is working fine!!!";
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	@GetMapping("/")
	@ResponseBody
	public UserDto getUserById(@RequestParam String userId) {
		return this.userService.getUserById(userId);
	}

	@GetMapping("/list")
	public List<User> getAllUser() {
		return this.userService.getAllUSer();
	}

	@PutMapping("/update")
	@ResponseBody
	public User updateBasicDetails(@RequestBody User user, @RequestParam String userId) {
		return this.userService.updateBasicProfile(user, userId);
	}

	@PutMapping("/event/bookmark")
	@ResponseBody
	public User updateEventsList(@RequestParam String userId, @RequestParam String eventId) {
		return this.userService.updateEventList(userId, eventId);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public String deleteUserProfile(@RequestParam String userId) {
		return this.userService.deleteUserProfile(userId);
	}

	@PutMapping("/event/unbookmark")
	@ResponseBody
	public User unBookmarkEvent(@RequestParam String userId, @RequestParam String eventId) {
		return this.userService.unBookmarkEvent(userId, eventId);
	}

	@PutMapping("/goal/add")
	@ResponseBody
	public User addGoal(@RequestBody GoalDto goaldto, @RequestParam String userId) {
		return this.userService.addGoal(goaldto, userId);
	}
	
	@PutMapping("/goal/complete")
	@ResponseBody
	public User completedGoal(@RequestParam String userId,@RequestParam String goalId) {
		return this.userService.completedGoal(userId, goalId);
	}

}
