package com.swapsell.UserService.repository;

import com.swapsell.UserService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

}