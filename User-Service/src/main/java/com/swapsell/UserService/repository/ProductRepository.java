package com.swapsell.UserService.repository;

import com.swapsell.UserService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
