package com.kafka.KafkaPoc2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_dest")
public class Product {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column(name = "createdtimestamp")
    private LocalDateTime createdTimeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Product(Integer id,String name, LocalDateTime createdTimeStamp) {
        this.id=id;
        this.name = name;
        this.createdTimeStamp = createdTimeStamp;
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTimeStamp=" + createdTimeStamp +
                '}';
    }
}
