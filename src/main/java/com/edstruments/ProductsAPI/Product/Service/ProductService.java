package com.edstruments.ProductsAPI.Product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstruments.ProductsAPI.Product.Exception.CustomException;
import com.edstruments.ProductsAPI.Product.Exception.ExceptionCode;
import com.edstruments.ProductsAPI.Product.Model.Product;
import com.edstruments.ProductsAPI.Product.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts()  {
		List<Product> products = productRepository.findAll(); 
		if(products.isEmpty()) {
			throw new CustomException(ExceptionCode.PRODUCT_NOT_FOUND); 
		}
		return products;
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product); 
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product updateProduct(Long id,Product product) {
		Product currProduct = getProductById(id).orElseThrow(() -> new CustomException(ExceptionCode.INVALID_REQUEST)); 
		currProduct.setDescription(product.getDescription());
		currProduct.setName(product.getName());
		currProduct.setPrice(product.getPrice()); 
		return productRepository.save(currProduct); 
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	
}
