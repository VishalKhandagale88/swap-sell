package com.swapsell.ProductService.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.cypherdsl.core.Use;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnsRelationShip {
    @Id
    @GeneratedValue
    private Long id;
    private List<String> products = new ArrayList<>();
    @StartNode
    private Use user;
    @EndNode
    private Product product;

}
