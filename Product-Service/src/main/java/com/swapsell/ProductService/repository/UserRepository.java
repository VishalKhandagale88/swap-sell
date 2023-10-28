package com.swapsell.ProductService.repository;

import com.swapsell.ProductService.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User",path = "User")
public interface UserRepository extends Neo4jRepository<User,Long> {
}
