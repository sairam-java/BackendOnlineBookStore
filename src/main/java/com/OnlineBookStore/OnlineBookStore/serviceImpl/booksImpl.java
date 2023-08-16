package com.OnlineBookStore.OnlineBookStore.serviceImpl;

import com.OnlineBookStore.OnlineBookStore.entity.booksEntity;
import com.OnlineBookStore.OnlineBookStore.exceptions.bookNotFounException;
import com.OnlineBookStore.OnlineBookStore.service.booksService;
import com.OnlineBookStore.OnlineBookStore.repository.booksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.OnlineBookStore.payload.booksResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class booksImpl implements booksService {

    @Autowired
    private booksRepo booksRepo;
    @Override
    public booksEntity createBook(booksEntity book) {
        booksEntity savedRecord = booksRepo.save(book);
        return savedRecord;
    }

    @Override
    public booksResponse getBookById(Long bookId) {

        Optional<booksEntity> bookById = booksRepo.findById(bookId);
        if (bookById.isPresent()){
            booksEntity booksEntity = bookById.get();
            booksResponse response = new booksResponse();
            response.setBookTitle(booksEntity.getBookTitle());
            response.setBookId(booksEntity.getBookId());
            response.setAuthor(booksEntity.getAuthor());
            response.setDescription(booksEntity.getDescription());
            response.setPrice(booksEntity.getPrice());
            return response;
        }
        else {
            throw new bookNotFounException(bookId);
        }
    }

    @Override
    public List<booksResponse> getAllBooks() {
        List<booksResponse> books = new ArrayList<>();
        List<booksEntity> allBooksList = booksRepo.findAll();
        for(booksEntity book: allBooksList){
            booksResponse booksResponse = convertBooksEntityToResponse(book);
            books.add(booksResponse);
        }

        return books;
    }

    @Override
    public String deleteBookById(Long bookId) {
        Optional<booksEntity> byId = booksRepo.findById(bookId);
        if (byId.isPresent()){
            booksRepo.deleteById(bookId);
            return "Deleted the Book";
        }
        else{
            return "Book Not Found To Delete";
        }
    }

    @Override
    public void updateStock(Long bookId) {
        Optional<booksEntity> byId = booksRepo.findById(bookId);
        if (byId.isPresent()){
            int stockInQuantity = byId.get().getStockInQuantity();
            booksEntity book = new booksEntity();
            book.setBookId(byId.get().getBookId());
            book.setBookTitle(byId.get().getBookTitle());
            book.setAuthor(byId.get().getAuthor());
            book.setDescription(byId.get().getDescription());
            book.setStockInQuantity(stockInQuantity-1);
            book.setPrice(byId.get().getPrice());
            booksRepo.save(book);
        }
    }

    @Override
    public boolean isBookAvalaibleAndInStock(Long bookId) {
        Optional<booksEntity> byId = booksRepo.findById(bookId);
        return byId.isPresent() && byId.get().getStockInQuantity()>0;
    }

    @Override
    public booksEntity getBooksEntityById(Long bookId) {
        Optional<booksEntity> byId = booksRepo.findById(bookId);
        return byId.get();
    }

    @Override
    public int getPriceOfEachBook(Long bookId) {
        Optional<booksEntity> byId = booksRepo.findById(bookId);
        return byId.get().getPrice();
    }

    private booksResponse convertBooksEntityToResponse(booksEntity book) {
        booksResponse bookRes = new booksResponse();
        bookRes.setPrice(book.getPrice());
        bookRes.setBookTitle(book.getBookTitle());
        bookRes.setAuthor(book.getAuthor());
        bookRes.setBookId(book.getBookId());
        bookRes.setDescription(bookRes.getDescription());

        return bookRes;
    }
}
