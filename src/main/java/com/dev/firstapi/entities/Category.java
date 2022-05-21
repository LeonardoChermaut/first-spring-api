package com.dev.firstapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "cat_id")
	private Long id;
	@Column(name= "cat_name")
	private String name;
	@Column(name= "cat_desc")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	protected List<Product> products = new ArrayList<>();
	

	public Category() {
		
	}

	public Category(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Category)) return false;
		Category category = (Category) o;
		return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName()) && Objects.equals(getDescription(), category.getDescription()) && Objects.equals(getProducts(), category.getProducts());
	}

}
