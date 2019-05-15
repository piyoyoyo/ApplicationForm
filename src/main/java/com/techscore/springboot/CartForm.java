package com.techscore.springboot;

import java.time.LocalDate;

public class CartForm {
	// メニュー名 価格 数量 カートに入った日付
	private String name;
	private int price;
	private int quantity;
	private LocalDate inCartAt;

	public CartForm(String name, int price, int quantity, LocalDate inCartAt) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.inCartAt = inCartAt;
	}

	// 空のコンストラクタが必要（らしい。）
	public CartForm() {
	}

	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public LocalDate getInCartAt() {
		return inCartAt;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setInCartAt(LocalDate inCartAt) {
		this.inCartAt = inCartAt;
	}
}
