package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.entity.BookOrders;
import com.books.entity.BookStore;
import com.books.service.BookServices;

@RestController
@RequestMapping("/api")
public class BookController 
{
	@Autowired
     private BookServices service;
	
	@PostMapping("/add")
	public String saveBook(@RequestBody BookStore book)
	{
		service.save(book);
		return "Book Record Saved Succesfully";
	}
     
	@PostMapping("/purchase")
	public Double purchaseBook(@RequestBody List<BookOrders> orders)
	{
		return service.purchase(orders);
	}
	
	@GetMapping("/findbybookname")
	public BookStore findBook(@RequestParam("bookname") String bookname) {
		return service.findBook(bookname);
	}
	
	@GetMapping("/gethistory")
	public BookOrders getTransactionHistory(@RequestParam("customerid") int customerId)
	{
		BookOrders historyTransaction = service.getHistoryTransaction(customerId);
		return historyTransaction;
	}
}
