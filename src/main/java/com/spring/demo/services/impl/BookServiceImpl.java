package com.spring.demo.services.impl;

import com.spring.demo.dao.impl.JdbcBook;
import com.spring.demo.models.Book;
import com.spring.demo.services.BookService;

import java.util.List;

/**
 * Created by Артём on 24.08.2017.
 */
public class BookServiceImpl implements BookService {

    private JdbcBook bookDao;

    public void setBookDao(JdbcBook bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public Book findById(int id) {
        return bookDao.findById(id);
    }

    public void insert(Book book) {
        bookDao.insert(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

}
