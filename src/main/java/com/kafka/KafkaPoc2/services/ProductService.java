package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Product;
import com.kafka.KafkaPoc2.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Integer id, String name) {
        var timestamp = LocalDateTime.now();
        Product product = new Product(id,name, timestamp);
        var res = productRepository.save(product);
        return res;
    }

    @Override
    public List<Product> findByName(String name) {
        var res = productRepository.findByName(name);
        return res;
    }
}
