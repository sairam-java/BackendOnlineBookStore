package com.OnlineBookStore.OnlineBookStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ordersDto {

    private String address;
    private Long userId;
    private List<Long> bookId;
}
