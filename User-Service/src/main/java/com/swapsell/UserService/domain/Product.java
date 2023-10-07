package com.swapsell.UserService.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    private String name;
    private String title;
    private String description;
    private byte image;
    private double price;
    private String category;
    private String condition;
    private int ageInDays;
    private boolean exchangeable;
    private String state;
    private String city;
    private LocalDateTime addPostedOnDate;
    private List<Product> products;
}
