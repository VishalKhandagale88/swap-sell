package com.swapsell.ProductService.repository;

import com.swapsell.ProductService.domain.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Product", path = "Product")
public interface ProductRepository extends Neo4jRepository<Product,Long> {
}
