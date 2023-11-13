package com.sm.service;

import java.util.List;

import com.sm.entity.Product;
import com.sm.form.ProductFormForCreating;
import com.sm.form.ProductFormForUpdating;

public interface IProductService {
	public List<Product> getAllProducts();

	public Product getProductById(short id);

	public Product createNewProduct(ProductFormForCreating productNewForm);

	public Product updateProduct(short id, ProductFormForUpdating productUpdateForm);

	public void deleteProductById(short id);

}
