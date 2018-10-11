package com.arif.springrest.rest;

import com.arif.springrest.entity.Book;
import com.arif.springrest.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping(path = "/")
    public Iterable<Book> getAllBooks() {
        return repository.findAll();
    }

    @PostMapping(path = "/")
    public Book add(@RequestBody Book book) {
        return repository.save(book);
    }

}
