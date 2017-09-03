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

    private static final String FIND_ALL_BOOKS = "SELECT * FROM  \"public\".\"book\"";

    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Book> findAll() {
        return this.template.query(FIND_ALL_BOOKS, new Object[]{}, new BookMapper());
    }
}
