package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.entity.BookOrders;

@Repository
public interface OrderRepo extends JpaRepository<BookOrders, Integer>
{
   public BookOrders findByCustomerId(int customerId);
}
