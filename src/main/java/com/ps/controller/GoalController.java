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

import com.ps.model.Goal;
import com.ps.service.GoalService;

@RestController
@RequestMapping("/v1/api/goal")
public class GoalController {

	@Autowired
	private GoalService goalService;

	@PostMapping("/add")
	public Goal addGoal(@RequestBody Goal goal) {
		return this.goalService.addGoal(goal);
	}

	@PutMapping("/update")
	@ResponseBody
	public Goal updateGoal(@RequestBody Goal goal, @RequestParam Integer goalId) {
		return this.goalService.updateGoal(goal, goalId);
	}

	@GetMapping("/list")
	public List<Goal> getAllGoals() {
		return this.goalService.getAllGoal();
	}

	@GetMapping("/goalById")
	@ResponseBody
	public Goal getGoalById(@RequestParam Integer goalId) {
		return this.goalService.getGoalById(goalId);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public String deleteGoalById(@RequestParam Integer goalId) {
		return this.goalService.deleteGoal(goalId);
	}
}
