package com.books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.entity.BookOrders;
import com.books.entity.BookStore;

@Service
public interface BookServices 
{
    public void save(BookStore books);
    public double purchase(List<BookOrders> orders);
    public BookStore findBook(String bookName);
    public BookOrders getHistoryTransaction(int customerId);
    
}
