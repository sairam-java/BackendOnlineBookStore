package com.OnlineBookStore.OnlineBookStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userDto {

    private String userName;
    private String password;
    private String role;

}
