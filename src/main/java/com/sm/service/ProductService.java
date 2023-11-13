package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.entity.Category;
import com.sm.entity.Color;
import com.sm.entity.Manufacturer;
import com.sm.entity.Product;
import com.sm.entity.Size;
import com.sm.form.ProductFormForCreating;
import com.sm.form.ProductFormForUpdating;
import com.sm.repository.ICategoryRepository;
import com.sm.repository.IColorRepository;
import com.sm.repository.IManufacturerRepository;
import com.sm.repository.IProductRepository;
import com.sm.repository.ISizeRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired 
	private IManufacturerRepository manufacturerRepository;
	
	@Autowired 
	private ISizeRepository sizeRepository;
	
	@Autowired 
	private IColorRepository colorRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(short id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
		
	}
	
	@Override
	public Product createNewProduct(ProductFormForCreating productNewForm) {
		
	    Manufacturer manufacturer = manufacturerRepository.getById(productNewForm.getManufacturerId());
	    Category category = categoryRepository.getById(productNewForm.getCategoryId());
	    Size size = sizeRepository.getById(productNewForm.getSizeId());
	    Color color = colorRepository.getById(productNewForm.getColorId());

	    Product product = new Product();
	    product.setName(productNewForm.getName());
	    product.setPrice(productNewForm.getPrice());
	    product.setDiscount(productNewForm.getDiscount());
	    product.setDescription(productNewForm.getDescription());
	    product.setCategory(category);
	    product.setManufacturer(manufacturer);
	    product.setRatingStar(productNewForm.getRatingStar());
	    product.setSize(size);
	    product.setColor(color);
	    product.setQuantity(productNewForm.getQuantity());
	    product.setImageName(productNewForm.getImageName());

	    try {
	        Product productNew = productRepository.save(product);
	        return productNew;
	    } catch (Exception e) {
	        // Xử lý ngoại lệ, ví dụ: log lỗi và ném ngoại lệ tương ứng
	        throw new RuntimeException("Không thể tạo mới sản phẩm: " + e.getMessage());
	    }
	}
	
	@Override
	public Product updateProduct(short id, ProductFormForUpdating productUpdateForm) {
		Product product = productRepository.getById(id);
		
		Manufacturer manufacturer =
				manufacturerRepository.getById(productUpdateForm.getManufacturerId());
		
		Category category = 
				categoryRepository.getById(productUpdateForm.getCategoryId());
		
		Size size = sizeRepository.getById(productUpdateForm.getSizeId());
		
		Color color = colorRepository.getById(productUpdateForm.getColorId());
		
		product.setName(productUpdateForm.getName());
		product.setPrice(productUpdateForm.getPrice());
		product.setDiscount(productUpdateForm.getDiscount());
		product.setDescription(productUpdateForm.getDescription());
		product.setCategory(category);
		product.setManufacturer(manufacturer);
		product.setRatingStar(productUpdateForm.getRatingStar());
		product.setSize(size);
		product.setColor(color);
		product.setQuantity(productUpdateForm.getQuantity());
		product.setImageName(productUpdateForm.getImageName());


		Product productUpdate = productRepository.save(product);
		return productUpdate;

	}
	
	@Override
	public void deleteProductById(short id) {
		productRepository.deleteById(id);
		
	}
	
	
}
