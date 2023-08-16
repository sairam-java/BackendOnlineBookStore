package com.OnlineBookStore.OnlineBookStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class ordersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false, unique = true)
    private Long orderId;

    @Column(name = "OrderDate")
    private LocalDateTime orderDate;

    @Column(name = "TotalOrderPrice")
    private int totalPrice;

    @Column(name = "Address")
    private String address;

    @Column(name = "TotalQuantity")
    private int totalQuantity;

    @ManyToOne
    @JoinColumn(name = "userId")
    private userEntity userId;

    @ManyToMany
    @JoinTable(
            name = "orderedBooks",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )
    private List<booksEntity> books;
}