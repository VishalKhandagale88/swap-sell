package com.swapsell.ProductService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

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
    private String data;
    private List<String> images;
}
