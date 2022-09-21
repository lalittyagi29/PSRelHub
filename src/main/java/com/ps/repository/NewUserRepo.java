package com.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ps.model.User;

public interface NewUserRepo extends MongoRepository<User, String> {

}
