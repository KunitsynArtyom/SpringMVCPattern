package com.spring.demo.dao.impl;

import com.spring.demo.dao.BookDao;
import com.spring.demo.mappers.BookMapper;
import com.spring.demo.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Артём on 24.08.2017.
 */
public class JdbcBook implements BookDao {

    private JdbcTemplate template;

    private static final String FIND_ALL_BOOKS = "SELECT * FROM Book";
    private static final String FIND_BOOK_BY_ID = "SELECT FROM Book WHERE id = ?";
    private static final String ADD_NEW_BOOK = "INSERT INTO Book(id, title, author) VALUES (book_seq.NEXTVAL, ?, ?)";
    private static final String UPDATE_BOOK = "UPDATE Book SET title = ?, author = ? WHERE id = ?";

    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Book> findAll() {
        return this.template.query(FIND_ALL_BOOKS, new Object[]{}, new BookMapper());
    }

    public Book findById(int id) {
        return this.template.queryForObject(FIND_BOOK_BY_ID, new Object[]{id}, new BookMapper());
    }

    public void insert(Book book) {
        this.template.update(ADD_NEW_BOOK, new Object[]{
                book.getTitle(),
                book.getAuthor()
        });
    }

    public void update(Book book) {
        this.template.update(UPDATE_BOOK, new Object[]{
                book.getTitle(),
                book.getAuthor(),
                book.getId()
        });
    }

}
