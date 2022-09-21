package com.ps.service;

import java.util.List;

import com.ps.model.Goal;

public interface GoalService {

	Goal addGoal(Goal goal);

	Goal updateGoal(Goal goal, Integer goalId);

	String deleteGoal(Integer goalId);

	List<Goal> getAllGoal();

	Goal getGoalById(Integer goalId);

}
