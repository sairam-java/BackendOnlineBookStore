package com.OnlineBookStore.OnlineBookStore.service;

import com.OnlineBookStore.OnlineBookStore.entity.booksEntity;
import com.OnlineBookStore.OnlineBookStore.payload.booksResponse;

import java.util.List;
import java.util.Optional;

public interface booksService {

    public booksEntity createBook(booksEntity book);

    public booksResponse getBookById(Long bookId);

    public List<booksResponse> getAllBooks();

    public String deleteBookById(Long bookId);

    public void updateStock(Long bookId);

    public boolean isBookAvalaibleAndInStock(Long bookId);

    public booksEntity getBooksEntityById(Long bookId);

    public int getPriceOfEachBook(Long bookId);
}
