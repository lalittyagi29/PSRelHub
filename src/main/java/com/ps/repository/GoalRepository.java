package com.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ps.model.Goal;

public interface GoalRepository extends MongoRepository<Goal, Integer> {

}
