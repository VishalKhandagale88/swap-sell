package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;
import com.swapsell.ProductService.domain.User;

import java.util.List;

public interface ProductService {
    User addNewUser(User user);

    List<Product> addNewProduct(List<ProductDTO> productDTOList);
}
