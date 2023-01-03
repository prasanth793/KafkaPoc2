package com.kafka.KafkaPoc2.repos;

import com.kafka.KafkaPoc2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from product_dest pd where pd.name = ?1",nativeQuery = true)
    List<Product> findByName(String name);
}
