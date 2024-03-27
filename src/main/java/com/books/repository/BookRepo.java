package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.entity.BookStore;

@Repository
public interface BookRepo extends JpaRepository<BookStore, Integer>
{
    public BookStore findByBookName(String bookName);
}
