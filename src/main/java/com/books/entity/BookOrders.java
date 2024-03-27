package com.books.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookOrders
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int orderId;
   private int customerId;
   private String customerName;
   private String customerAddress;
   private String bookName;
   private int noOfBooksOrdered;
   

public BookOrders(int customerId, String customerName, String customerAddress, String bookName, int noOfBooksOrdered) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	this.bookName = bookName;
	this.noOfBooksOrdered = noOfBooksOrdered;
}


@Override
public int hashCode() {
	return Objects.hash(bookName, customerAddress, customerId, customerName, noOfBooksOrdered);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BookOrders other = (BookOrders) obj;
	return Objects.equals(bookName, other.bookName) && Objects.equals(customerAddress, other.customerAddress)
			&& customerId == other.customerId && Objects.equals(customerName, other.customerName)
			&& noOfBooksOrdered == other.noOfBooksOrdered;
}


@Override
public String toString() {
	return "BookOrders [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
			+ customerAddress + ", bookName=" + bookName + ", noOfBooksOrdered=" + noOfBooksOrdered + "]";
}


public int getCustomerId() {
	return customerId;
}


public void setCustomerId(int customerId) {
	this.customerId = customerId;
}


public String getCustomerName() {
	return customerName;
}


public void setCustomerName(String customerName) {
	this.customerName = customerName;
}


public String getCustomerAddress() {
	return customerAddress;
}


public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}


public String getBookName() {
	return bookName;
}


public void setBookName(String bookName) {
	this.bookName = bookName;
}


public int getNoOfBooksOrdered() {
	return noOfBooksOrdered;
}


public void setNoOfBooksOrdered(int noOfBooksOrdered) {
	this.noOfBooksOrdered = noOfBooksOrdered;
}


public BookOrders() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
