package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public Product addNewProduct(Product product) {
        return null;
    }
}
