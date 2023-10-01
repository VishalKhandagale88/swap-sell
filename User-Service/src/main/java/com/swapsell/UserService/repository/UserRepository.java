package com.swapsell.UserService.repository;

import com.swapsell.UserService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {
}
