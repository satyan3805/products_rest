package com.sat.tmf.productrest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sat.tmf.productrest.entity.Category;
import com.sat.tmf.productrest.entity.Product;
import com.sat.tmf.productrest.repository.CategoryRepository;
import com.sat.tmf.productrest.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		Long categoryId = product.getCategory().getCatId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
        product.setCategory(category);
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(existingProduct -> {
        	existingProduct.setProductName(updatedProduct.getProductName());
        	existingProduct.setProductDesc(updatedProduct.getProductDesc());
        	existingProduct.setProductPrice(updatedProduct.getProductPrice());
        	existingProduct.setCategory(updatedProduct.getCategory());
            return productRepository.save(updatedProduct);
        });
    }
    
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
        	productRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Page<Product> getProductsByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

	public Page<Product> getProductsWithPagination(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
}
