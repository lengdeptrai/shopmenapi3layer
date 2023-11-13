package com.sm.entity;

import java.io.Serializable;

import org.springframework.web.jsf.FacesContextUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Product" ,catalog = "ShopMen")
public class Product implements Serializable{
	public short getDiscount() {
		return discount;
	}

	public void setDiscount(short discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Column(name = "ProductId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "ProductName", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "ProductPrice",  nullable = false)
	private Double price;
	
	@Column(name = "Discount", length = 2)
	private short discount;

	@Column(name = "ProductDescription", length = 500)
	private String description;

	@Column(name = "RatingStar")
	private short ratingStar;

	@Column(name = "ProductImageName", length = 50, nullable = false)
	private String imageName;

	@ManyToOne
	@JoinColumn(name = "ManufacturerId", nullable = false)
	private Manufacturer manufacturer;

	@ManyToOne
	@JoinColumn(name = "CategoryId", nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "SizeId", nullable = false)
	private Size size;
	
	@ManyToOne
	@JoinColumn(name = "ColorId", nullable = false)
	private Color color;
	
	
	@Column(name = "Quantity", nullable = false)
	private int quantity;
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
