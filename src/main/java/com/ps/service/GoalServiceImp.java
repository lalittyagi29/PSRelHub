package com.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.model.Goal;
import com.ps.repository.GoalRepository;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalRepository goalRepository;

	@Override
	public Goal addGoal(Goal goal) {
		return this.goalRepository.save(goal);
	}

	@Override
	public Goal updateGoal(Goal goal, Integer goalId) {
		Goal current_Goal = this.goalRepository.findById(goalId).orElseThrow();
		if (goal.getTitle() != null) {
			current_Goal.setTitle(goal.getTitle());
		}
		return this.goalRepository.save(current_Goal);
	}

	@Override
	public String deleteGoal(Integer goalId) {
		try {
			this.goalRepository.deleteById(goalId);
			return "Sucess!!";
		} catch (Exception e) {
			return "Error!!";
		}
	}

	@Override
	public List<Goal> getAllGoal() {
		return this.goalRepository.findAll();
	}

	@Override
	public Goal getGoalById(Integer goalId) {
		return this.goalRepository.findById(goalId).orElseThrow();
	}
}
