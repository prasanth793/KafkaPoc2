package com.kafka.KafkaPoc2.controllers;

import com.kafka.KafkaPoc2.model.Product;
import com.kafka.KafkaPoc2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    List<Product> findByName(@RequestParam("pname") String name){
        var res = productService.findByName(name);
        return res;
    }

    @PostMapping("/saveproduct")
    Product save(@RequestParam("pid") Integer id , @RequestParam("pname") String name){
        var res = productService.save(id,name);
        return res;
    }
}
