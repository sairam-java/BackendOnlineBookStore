package com.OnlineBookStore.OnlineBookStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
public class booksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookId", nullable = false, unique = true)
    private Long bookId;

    @Column(name = "BookTitle")
    private String bookTitle;

    @Column(name = "Author")
    private String author;

    @Column(name = "Description")
    private String description;

    @Column(name = "InStock")
    private int stockInQuantity;

    @Column(name = "Price")
    private int price;
}
