package com.techscore.springboot;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="menuId")
	private Long menuId;
	@Column(name="quantity")
	private int quantity;
	@Column(name="inCart")
	private boolean inCart;
	@Column(name="inCartAt")
	private LocalDate inCartAt;

	public CartItem(Long menuId, int quantity, boolean inCart, LocalDate inCartAt) {
		this.menuId = menuId;
		this.quantity = quantity;
		this.inCart = inCart;
		this.inCartAt = inCartAt;
	}

	// 空のコンストラクタが必要（らしい。）
	public CartItem() {
	}

	public Long getId() {
		return id;
	}
	public Long getMenuId() {
		return menuId;
	}
	public int getQuantity() {
		return quantity;
	}

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }
	public LocalDate getInCartAt() {
		return inCartAt;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setInCartAt(LocalDate inCartAt) {
		this.inCartAt = inCartAt;
	}

}
