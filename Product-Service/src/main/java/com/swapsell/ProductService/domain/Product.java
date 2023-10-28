package com.swapsell.ProductService.domain;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    private Long id;
    private String name;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String condition;
    private Integer ageInDays;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String date;
    private List<String> images;
    @Transient
    private User seller;
    @Relationship(type = "OWNS",direction = Relationship.Direction.INCOMING)
    private OwnsRelationShip ownsRelationShip;
}
