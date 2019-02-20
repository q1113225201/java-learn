package com.sjl.learn.controller;

import com.sjl.learn.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookProperties bookProperties;

    @RequestMapping("/book/getBook")
    public BookProperties getBook(){
        return bookProperties;
    }
}
