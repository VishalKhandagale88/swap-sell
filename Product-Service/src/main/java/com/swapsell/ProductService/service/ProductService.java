package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;

public interface ProductService {
    Product addNewProduct(ProductDTO productDTO);

}
