package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;
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
    public Product addNewProduct(ProductDTO productDTO) {
        Product product1 = new Product();
        product1.setName(productDTO.getName());
        product1.setTitle(productDTO.getTitle());
        product1.setDescription(productDTO.getDescription());
        product1.setCategory(productDTO.getCategory());
        product1.setPrice(productDTO.getPrice());
        product1.setAgeInDays(productDTO.getAgeInDays());
        product1.setCondition(productDTO.getCondition());
        product1.setAddress(productDTO.getAddress());
        product1.setCity(productDTO.getCity());
        product1.setState(productDTO.getState());
        product1.setPinCode(productDTO.getPinCode());
        product1.setDate(productDTO.getDate());
        product1.setImages(productDTO.getImages());

        Product newProduct = productRepository.save(product1);

        userRepository.createOwnsRelationship(productDTO.getEmail(), newProduct.getId());

        return newProduct;

    }
}
