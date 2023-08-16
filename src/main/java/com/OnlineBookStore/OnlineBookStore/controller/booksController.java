package com.OnlineBookStore.OnlineBookStore.controller;

import com.OnlineBookStore.OnlineBookStore.entity.booksEntity;
import com.OnlineBookStore.OnlineBookStore.payload.booksResponse;
import com.OnlineBookStore.OnlineBookStore.repository.userRepo;
import com.OnlineBookStore.OnlineBookStore.serviceImpl.booksImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class booksController {

    @Autowired
    private booksImpl booksImpl;
    @Autowired
    private com.OnlineBookStore.OnlineBookStore.repository.userRepo userRepo;

    @PostMapping("/")
    public ResponseEntity<booksEntity> createBooks(@RequestBody booksEntity books){
        booksEntity createdBook = booksImpl.createBook(books);
        return new ResponseEntity<booksEntity>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<booksResponse> getBookById(@PathVariable Long bookId){
        booksResponse bookById = booksImpl.getBookById(bookId);
        return new ResponseEntity<booksResponse>(bookById, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<booksResponse>> getAllBooks(){
        List<booksResponse> allBooks = booksImpl.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteUseById(@PathVariable Long bookId){
        String responseStatus = booksImpl.deleteBookById(bookId);
        return new ResponseEntity<>(responseStatus, HttpStatus.OK);
    }

}
