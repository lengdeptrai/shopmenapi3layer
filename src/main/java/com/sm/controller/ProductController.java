package com.sm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.dto.ProductDto;
import com.sm.entity.Product;
import com.sm.form.ProductFormForCreating;
import com.sm.form.ProductFormForUpdating;
import com.sm.service.ICategoryService;
import com.sm.service.IColorService;
import com.sm.service.IManufacturerService;
import com.sm.service.IProductService;
import com.sm.service.ISizeService;

@RestController
@RequestMapping(value = "api/v1/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		try {
			List<Product> productListDB = productService.getAllProducts();
			List<ProductDto> productListDto = new ArrayList<>();

			// convert productListDB --> productListDto
			for (Product productDB : productListDB) {
				ProductDto productDto = new ProductDto();
				productDto.setId(productDB.getId());
				productDto.setName(productDB.getName());
				productDto.setPrice(productDB.getPrice());
				productDto.setDiscount(productDB.getDiscount());
				productDto.setDescription(productDB.getDescription());
				productDto.setRatingStar(productDB.getRatingStar());
				productDto.setImageName(productDB.getImageName());
				productDto.setColorName(productDB.getColor().getName());
				productDto.setSizeName(productDB.getSize().getName().toString());
				productDto.setQuantity(productDB.getQuantity());
				productDto.setManufacturerName(productDB.getManufacturer().getName().toString());
				productDto.setCategoryName(productDB.getCategory().getName());

				productListDto.add(productDto);

			}
			return new ResponseEntity<>(productListDto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("EXPECTATION_FAILED", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getProductByID(@PathVariable(name = "id") short id) {
		try {
			Product productDB = productService.getProductById(id);

			ProductDto productDto = new ProductDto();
			productDto.setId(productDB.getId());
			productDto.setName(productDB.getName());
			productDto.setPrice(productDB.getPrice());
			productDto.setDiscount(productDB.getDiscount());
			productDto.setDescription(productDB.getDescription());
			productDto.setRatingStar(productDB.getRatingStar());
			productDto.setImageName(productDB.getImageName());
			productDto.setColorName(productDB.getColor().getName());
			productDto.setSizeName(productDB.getSize().getName().toString());
			productDto.setQuantity(productDB.getQuantity());
			productDto.setManufacturerName(productDB.getManufacturer().getName().toString());
			productDto.setCategoryName(productDB.getCategory().getName());

			return new ResponseEntity<>(productDto, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> createNewproduct(@RequestBody ProductFormForCreating productNewForm) {

		try {
//			Thêm mới Product
//			Sau khi thêm mới, trả về thông tin Product vừa thêm
			Product productNew = productService.createNewProduct(productNewForm);

//			Convert
			ProductDto productNewDto = new ProductDto();
			productNewDto.setId(productNew.getId());
			productNewDto.setName(productNew.getName());
			productNewDto.setPrice(productNew.getPrice());
			productNewDto.setDiscount(productNew.getDiscount());
			productNewDto.setDescription(productNew.getDescription());
			productNewDto.setRatingStar(productNew.getRatingStar());
			productNewDto.setImageName(productNew.getImageName());
			productNewDto.setColorName(productNew.getColor().getName());
			productNewDto.setSizeName(productNew.getSize().toString());
			;
			productNewDto.setQuantity(productNew.getQuantity());
			productNewDto.setManufacturerName(productNew.getManufacturer().getName().toString());
			productNewDto.setCategoryName(productNew.getCategory().getName());

			return new ResponseEntity<>(productNewDto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exit created", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") short id,
			@RequestBody ProductFormForUpdating productUpdateForm) {
		try {
//			Thực hiện Update Product
//			Sau khi Update, trả về thông tin Product vừa Update
			Product productUpdate = productService.updateProduct(id, productUpdateForm);

//			Convert
			ProductDto productUpdateDto = new ProductDto();
			productUpdateDto.setId(productUpdate.getId());
			productUpdateDto.setName(productUpdate.getName());
			productUpdateDto.setPrice(productUpdate.getPrice());
			productUpdateDto.setDiscount(productUpdate.getDiscount());
			productUpdateDto.setDescription(productUpdate.getDescription());
			productUpdateDto.setRatingStar(productUpdate.getRatingStar());
			productUpdateDto.setImageName(productUpdate.getImageName());
			productUpdateDto.setColorName(productUpdate.getColor().getName());
			productUpdateDto.setSizeName(productUpdate.getSize().getName().toString());
			productUpdateDto.setQuantity(productUpdate.getQuantity());
			productUpdateDto.setManufacturerName(productUpdate.getManufacturer().getName().toString());
			productUpdateDto.setCategoryName(productUpdate.getCategory().getName());

			return new ResponseEntity<>(productUpdateDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable(name = "id") short id) {
		try {
//			Thực hiện lấy thông tin chi tiết của Product cần xóa, sau khi xóa xong thực hiện trả về thông tin chi tiết
//			của Product vừa xóa
			Product productDelete = productService.getProductById(id);

//			Convert
			ProductDto productDeleteDto = new ProductDto();
			productDeleteDto.setId(productDelete.getId());
			productDeleteDto.setName(productDelete.getName());
			productDeleteDto.setPrice(productDelete.getPrice());
			productDeleteDto.setDiscount(productDelete.getDiscount());
			productDeleteDto.setDescription(productDelete.getDescription());
			productDeleteDto.setRatingStar(productDelete.getRatingStar());
			productDeleteDto.setImageName(productDelete.getImageName());
			productDeleteDto.setColorName(productDelete.getColor().getName());
			productDeleteDto.setSizeName(productDelete.getSize().getName().toString());
			productDeleteDto.setQuantity(productDelete.getQuantity());
			productDeleteDto.setManufacturerName(productDelete.getManufacturer().getName().toString());
			productDeleteDto.setCategoryName(productDelete.getCategory().getName());

//			Xóa Product
			productService.deleteProductById(id);

			return new ResponseEntity<>(productDeleteDto, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}
}
