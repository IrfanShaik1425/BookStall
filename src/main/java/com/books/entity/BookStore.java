package com.books.entity;

import java.util.List;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class BookStore 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private double bookPrice;
    private int bookQuantity;
    
    @ManyToOne
    @JoinTable(name = "abc-xyz",
    joinColumns = { @JoinColumn(name = "xyz")},
    inverseJoinColumns = {@JoinColumn(name="abc")}
    )
    
    private BookOrders orders;
    
    
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	@Override
	public String toString() {
		return "BookStore [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookQuantity="
				+ bookQuantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, bookName, bookPrice, bookQuantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStore other = (BookStore) obj;
		return bookId == other.bookId && Objects.equals(bookName, other.bookName)
				&& Double.doubleToLongBits(bookPrice) == Double.doubleToLongBits(other.bookPrice)
				&& bookQuantity == other.bookQuantity;
	}
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookStore(int bookId, String bookName, double bookPrice, int bookQuantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookQuantity = bookQuantity;
	}
    
    
}
