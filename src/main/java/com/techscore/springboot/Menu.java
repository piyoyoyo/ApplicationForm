package com.techscore.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="menu")
	private String menu;
	@Column(name="price")
	private String price;

	public String getId() {
		return id;
	}
	public String getMenu() {
		return menu;
	}
	public String getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
