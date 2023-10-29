package com.swapsell.ProductService.contoller;

import com.swapsell.ProductService.domain.User;
import com.swapsell.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user){
        return null;
    }
}
