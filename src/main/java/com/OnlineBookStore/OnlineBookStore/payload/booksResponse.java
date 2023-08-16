package com.OnlineBookStore.OnlineBookStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class booksResponse {

    private Long bookId;
    private String bookTitle;
    private String author;
    private String description;
    private int price;
}
