package com.edstruments.ProductsAPI.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edstruments.ProductsAPI.Product.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
