package com.alexduzi.workshopuserspost.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alexduzi.workshopuserspost.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
