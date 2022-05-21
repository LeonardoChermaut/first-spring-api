package com.dev.firstapi.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "prod_id")
	private Long id;
	@Column(name= "prod_name")
	private String name;
	@Column(name= "prod_uni_val")
	private Double unitaryValue;
	@Column(name= "prod_desc")
	private String description;
	@Column(name= "prod_exp_date")
	private String expirationDate;
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category category;

public Product() {
	
}

	public Product(Long id, String name, Double unitaryValue, String description, String expirationDate, int quantity, Category category) {
		this.id = id;
		this.name = name;
		this.unitaryValue = unitaryValue;
		this.description = description;
		this.expirationDate = expirationDate;
		this.quantity = quantity;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitaryValue() {
		return unitaryValue;
	}

	public void setUnitaryValue(Double unitaryValue) {
		this.unitaryValue = unitaryValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return getQuantity() == product.getQuantity() && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getUnitaryValue(), product.getUnitaryValue()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getExpirationDate(), product.getExpirationDate()) && Objects.equals(getCategory(), product.getCategory());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getUnitaryValue(), getDescription(), getExpirationDate(), getQuantity(), getCategory());
	}
}

