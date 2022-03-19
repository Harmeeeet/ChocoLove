package com.choco.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartModel {

	@Id
	private String name;
	private int price;
	private int qt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public CartModel() {
		super();
		this.qt=0;
	}
}
