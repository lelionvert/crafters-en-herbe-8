package com.lcdlv.crafterenherbe.controller;

import com.lcdlv.crafterenherbe.model.Book;
import com.lcdlv.crafterenherbe.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Book")
@RestController
@RequestMapping("/")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }
}
