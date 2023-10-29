package com.swapsell.ProductService.domain;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

import javax.lang.model.element.NestingKind;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
public class ProductDTO {
    private String name;
    private String title;
    private String description;
    private Double price;
    private  String category;
    private String condition;
    private  Integer ageInDays;
    private String email;
    private  String address;
    private String city;
    private String state;
    private  Long pinCode;
    private String date;
    private List<String> images;

}
