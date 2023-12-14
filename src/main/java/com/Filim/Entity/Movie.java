package com.Filim.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50,nullable = false)
	private String name;
	@Column(length = 50,nullable = false)
	private String image;
	@Column(length = 20,nullable = false)
	private String category;
	@Column(length = 20,nullable = false)
	private String type;
	@Column(length = 2000,nullable = false)
	private String description;
	

	
	
	
	
	public Movie() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

    











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



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", image=" + image + ", category=" + category + ", type=" + type
				+ ", description=" + description + "]";
	}

	
	
	
	
}
