package com.swapsell.UserService.repository;

import com.swapsell.UserService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {
    Optional<Product> findProductById(String id);
}
