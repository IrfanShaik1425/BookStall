package com.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.entity.BookOrders;
import com.books.entity.BookStore;
import com.books.repository.BookRepo;
import com.books.repository.OrderRepo;

@Service
public class BookServiceImplementation implements BookServices
{
	@Autowired
   private BookRepo bookrepo;
	
	@Autowired
	private OrderRepo orderrepo;
	@Override
	public void save(BookStore books) {
		bookrepo.save(books);
		
	}
	@Override
	public double purchase(List<BookOrders> orders) {
		double totalPrice =0;
		for(BookOrders bookorders : orders)
		{

			BookStore book = bookrepo.findByBookName(bookorders.getBookName());
			if(book!=null && book.getBookQuantity()>= bookorders.getNoOfBooksOrdered())
			{
				book.setBookQuantity(book.getBookQuantity()-bookorders.getNoOfBooksOrdered());
				totalPrice += book.getBookPrice()* bookorders.getNoOfBooksOrdered();
				bookrepo.save(book);
				orderrepo.save(bookorders);
			}
		
		}
		return totalPrice;
	}
	@Override
	public BookStore findBook(String bookName) {
		BookStore findByBookName = bookrepo.findByBookName(bookName);
		return findByBookName;
	}
	@Override
	public BookOrders getHistoryTransaction(int customerId) 
	{
	    BookOrders bookorders = orderrepo.findByCustomerId(customerId);
	    return bookorders;
	}
	
	
}
