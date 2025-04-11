package com.seleniumExample.service;

public class Order {

	private String trackId;
	private Integer productId;
	private String name;
	private Integer quantity;
	private Double productPrice;
	private String productType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setTrackingId(String trackId) {
		this.trackId = trackId;

	}

	@Override
	public String toString() {
		return "Order [trackId=" + trackId + ", productId=" + productId + ", name=" + name + ", quantity=" + quantity
				+ ", productPrice=" + productPrice + ", productType=" + productType + "]";
	}

}
