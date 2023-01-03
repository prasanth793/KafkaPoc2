package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    Product save(Integer id, String name);


    List<Product> findByName(String name);
}
