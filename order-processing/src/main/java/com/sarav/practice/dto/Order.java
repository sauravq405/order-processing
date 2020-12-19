package com.sarav.practice.dto;

public class Order {
	private int id;
	private String status;

	public int getId() {
		return id;
	}

	public Order setId(int id) {
		this.id = id;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Order setStatus(String status) {
		this.status = status;
		return this;
	}

}
