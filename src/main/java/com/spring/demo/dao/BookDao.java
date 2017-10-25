package com.spring.demo.dao;

import com.spring.demo.models.Book;

import java.util.List;

/**
 * Created by Артём on 24.08.2017.
 */
public interface BookDao {
    List<Book> findAll();
    Book findById(int id);
    void insert(Book book);
    void update(Book book);
}
