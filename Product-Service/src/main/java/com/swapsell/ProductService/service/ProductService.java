package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;
import com.swapsell.ProductService.domain.User;

public interface ProductService {
    Product addNewProduct(ProductDTO productDTO);
    User addNewUser(User user);

}
