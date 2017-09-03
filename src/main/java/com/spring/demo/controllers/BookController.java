package com.spring.demo.controllers;

import com.spring.demo.models.Book;
import com.spring.demo.services.BookService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Артём on 24.08.2017.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class);


    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private BookService bookService = (BookService) context.getBean("bookServiceImpl");

    @RequestMapping("/all")
    public @ResponseBody
    List<Book> getBookList() {
        logger.debug("Request URL: /books/bookList.json; Entering getBookList()");
        List<Book> bookList = bookService.findAll();
        logger.debug("Response: " + bookList);
        return bookList;
    }

    @RequestMapping("/layout")
    public String getBookPartialPage() {
        return "books/layout";
    }
}
