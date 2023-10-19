package com.swapsell.UserService.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    @MongoId
    private String id;
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
}
