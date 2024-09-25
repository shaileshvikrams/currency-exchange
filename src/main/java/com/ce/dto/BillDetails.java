package com.ce.dto;

import java.util.List;

public class BillDetails {

	private List<Item> items;
	private double totalAmount;
	private String userType;
	private int customerTenure;
	private String originalCurrency;
	private String targetCurrency;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getCustomerTenure() {
		return customerTenure;
	}

	public void setCustomerTenure(int customerTenure) {
		this.customerTenure = customerTenure;
	}

	public String getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
}
