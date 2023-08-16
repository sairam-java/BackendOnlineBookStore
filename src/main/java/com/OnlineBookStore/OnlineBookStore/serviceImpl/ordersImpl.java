package com.OnlineBookStore.OnlineBookStore.serviceImpl;

import com.OnlineBookStore.OnlineBookStore.entity.booksEntity;
import com.OnlineBookStore.OnlineBookStore.entity.ordersEntity;
import com.OnlineBookStore.OnlineBookStore.exceptions.bookNotFounException;
import com.OnlineBookStore.OnlineBookStore.exceptions.romoveFromTheOrderException;
import com.OnlineBookStore.OnlineBookStore.payload.booksResponse;
import com.OnlineBookStore.OnlineBookStore.payload.ordersDto;
import com.OnlineBookStore.OnlineBookStore.payload.userResponse;
import com.OnlineBookStore.OnlineBookStore.repository.booksRepo;
import com.OnlineBookStore.OnlineBookStore.repository.ordersRepo;
import com.OnlineBookStore.OnlineBookStore.repository.userRepo;
import com.OnlineBookStore.OnlineBookStore.service.ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ordersImpl implements ordersService {

    @Autowired
    private ordersRepo orderRepo;

    @Autowired
    private booksImpl booksImpl;

    @Autowired
    private userImpl userImpl;

    @Autowired
    private userRepo userRepo;

    @Override
    public ordersEntity createOrder(ordersDto orderDetails) {
        userImpl.getUserById(orderDetails.getUserId());
        List<booksResponse> foundBooks = new ArrayList<>();
        List<Long> booksNotFound = new ArrayList<>();

        for(Long eachBook: orderDetails.getBookId()){
            if (booksImpl.isBookAvalaibleAndInStock(eachBook)){
                foundBooks.add(booksImpl.getBookById(eachBook));
            }
            else {
                booksNotFound.add(eachBook);
            }
        }
        if (booksNotFound.isEmpty()){
            ordersEntity order = new ordersEntity();
            order.setOrderDate(LocalDateTime.now());
            order.setAddress(orderDetails.getAddress());
            order.setUserId(userRepo.getById(orderDetails.getUserId()));//fix later
            List<booksEntity> booksEntities = new ArrayList<>();
            for (booksResponse bookResponse : foundBooks) {
                booksEntity booksEntityById = booksImpl.getBooksEntityById(bookResponse.getBookId());
                booksEntities.add(booksEntityById);
            }
            order.setBooks(booksEntities);
            int totalPrice=0;
            for (booksResponse booksResponse: foundBooks) {
                totalPrice += booksImpl.getBookById(booksResponse.getBookId()).getPrice();
            }
            order.setTotalPrice(totalPrice);
            order.setTotalQuantity(foundBooks.size());

            ordersEntity save = orderRepo.save(order);
            return save;

        }
        else {
                throw new romoveFromTheOrderException(booksNotFound);
        }
    }

}
