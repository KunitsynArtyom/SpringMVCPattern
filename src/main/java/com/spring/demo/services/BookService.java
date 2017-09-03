package com.spring.demo.services;

import com.spring.demo.models.Book;

import java.util.List;

/**
 * Created by Артём on 24.08.2017.
 */
public interface BookService {
    List<Book> findAll();
    //Book findById(int id);
    //void insert(Book book);
}
