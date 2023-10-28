package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.repository.ProductRepository;
import com.swapsell.ProductService.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addNewProduct(Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        product1.setAgeInDays(product.getAgeInDays());
        product1.setCondition(product.getCondition());
        product1.setAddress(product.getAddress());
        product1.setCity(product.getCity());
        product1.setState(product.getState());
        product1.setPinCode(product.getPinCode());
        product1.setDate(product.getDate());
        product1.setImages(product.getImages());

        Product newProduct = productRepository.save(product1);
        return null;

    }
}
