package com.ashish.ecom.repository;

import com.ashish.ecom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    public List<Product> findByPriceBetween(double a, double b);
    public Product findByTitle(String name);

    public  List<Product> findByTitleEndingWith(String title);

}
