package com.edstruments.ProductsAPI.Product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstruments.ProductsAPI.Product.Exception.CustomException;
import com.edstruments.ProductsAPI.Product.Exception.ExceptionCode;
import com.edstruments.ProductsAPI.Product.Model.Product;
import com.edstruments.ProductsAPI.Product.Service.ProductService;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController   {
	
	@Autowired
	private ProductService productService; 
	
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.getAllProducts(); 
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) throws CustomException {
		Optional<Product> product = productService.getProductById(id);
		if(product.isEmpty()) {
			//Product is not found 
			throw new CustomException(ExceptionCode.PRODUCT_NOT_FOUND);
		}
		return product;
	}
	
	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product); 
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		
		return productService.updateProduct(id,product); 
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id); 
	}
	
	
}
