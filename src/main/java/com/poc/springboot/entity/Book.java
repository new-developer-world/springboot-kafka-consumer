package com.poc.springboot.entity;

import java.util.Date;

public class Book {
	private String bookName;
	private String bookType;
	private int qty;
	private double price;
	private Date publishYear;
	
	public Book() {
		
	}

	public Book(String bookName, String bookType, int qty, double price, Date publishYear) {
		super();
		this.bookName = bookName;
		this.bookType = bookType;
		this.qty = qty;
		this.price = price;
		this.publishYear = publishYear;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Date publishYear) {
		this.publishYear = publishYear;
	}

}
