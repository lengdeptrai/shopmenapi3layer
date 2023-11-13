package com.sm.form;

public class ProductForm {

	public Double getPrice() {
		return price;
	}
	
	public short getDiscount() {
		return discount;
	}

	public void setDiscount(short discount) {
		this.discount = discount;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public short getRatingStar() {
		return ratingStar;
	}
	public void setRatingStar(short ratingStar) {
		this.ratingStar = ratingStar;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public short getSizeId() {
		return sizeId;
	}
	public void setSizeId(short sizeId) {
		this.sizeId = sizeId;
	}
	public short getColorId() {
		return colorId;
	}
	public void setColorId(short colorId) {
		this.colorId = colorId;
	}
	public short getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(short manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public short getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductForm() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private Double price;
	private short discount;
	private String description;
	private short ratingStar;
	private String imageName;
	private short sizeId;
	private short colorId;
	private short manufacturerId;
	private short categoryId;
	private int quantity;
}
