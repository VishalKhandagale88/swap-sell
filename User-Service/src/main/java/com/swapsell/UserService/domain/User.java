package com.swapsell.UserService.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Document
public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private  String address;
    private String city;
    private String state;
    private int pinCode;
    private String gender;
    private String image;
    private List<Product> products;
}
