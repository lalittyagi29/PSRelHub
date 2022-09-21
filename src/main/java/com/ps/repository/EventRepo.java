package com.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ps.model.Event;

public interface EventRepo extends MongoRepository<Event, String> {

}
