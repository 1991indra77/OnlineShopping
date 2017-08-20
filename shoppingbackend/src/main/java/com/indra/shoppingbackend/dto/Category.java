package com.indra.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Category {
	
	/**
	 * private fields
	 */
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="is_active")
	//0 means true and and non-zero means false
	private int active=0;
	
	/**
	 * Constructors
	 */
	
	Category(){
		
	}
	
	
	public Category(String name, String description, String imageUrl, int active) {
		super();
		
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.active = active;
	}


	/**
	 * public getters and setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int isActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", active=" + active + "]";
	}
	
	

	
	
}
