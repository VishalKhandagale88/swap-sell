package com.swapsell.ProductService.contoller;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;
import com.swapsell.ProductService.domain.User;
import com.swapsell.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/user")
    public User addNewUser(@RequestBody User user){
        return productService.addNewUser(user);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addNewProduct(@RequestBody List<ProductDTO> productDTOList){
        List<Product> products = productService.addNewProduct(productDTOList);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
