package com.swapsell.ProductService.repository;

import com.swapsell.ProductService.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User",path = "User")
public interface UserRepository extends Neo4jRepository<User,Long> {
    @Query(value = "MATCH (a:User {email:$email}),(b:Product)"+"WHERE ID(b) = $ProductId"+"CREATE (a)-[r:OWNS]->(b)")
    @Transactional
    void createOwnsRelationship(@Param("email")String firstName,@Param("productId")Long productId);
}
