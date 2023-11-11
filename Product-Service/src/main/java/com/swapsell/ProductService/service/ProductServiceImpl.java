package com.swapsell.ProductService.service;

import com.swapsell.ProductService.domain.Product;
import com.swapsell.ProductService.domain.ProductDTO;
import com.swapsell.ProductService.domain.User;
import com.swapsell.ProductService.repository.ProductRepository;
import com.swapsell.ProductService.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public User addNewUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public List<Product> addNewProduct(List<ProductDTO> productDTOList) {
        List<Product> newProducts = new ArrayList<>();
        for (ProductDTO productDTO : productDTOList){
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setTitle(productDTO.getTitle());
            product.setDescription(productDTO.getDescription());
            product.setCategory(productDTO.getCategory());
            product.setPrice(productDTO.getPrice());
            product.setAgeInDays(productDTO.getAgeInDays());
            product.setCondition(productDTO.getCondition());
            product.setAddress(productDTO.getAddress());
            product.setCity(productDTO.getCity());
            product.setState(productDTO.getState());
            product.setPinCode(productDTO.getPinCode());
            product.setDate(productDTO.getDate());
            product.setImages(productDTO.getImages());
            Product newProduct = productRepository.save(product);
            userRepository.createOwnsRelationship(productDTO.getEmail(),newProduct.getId());
            newProducts.add(newProduct);
        }
        return newProducts;
    }

}
