package com.swapsell.ProductService.domain;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.NestingKind;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductDTO {
    private String name;
    private String title;
    private String description;
    private Double price;
    private  String category;
    private  String ageInDays;
    private String email;
    private  String address;
    private String city;
    private String state;
    private  String pinCode;
    private String date;
    private List<String> images;

}
