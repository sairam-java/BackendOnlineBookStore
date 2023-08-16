package com.OnlineBookStore.OnlineBookStore.service;

import com.OnlineBookStore.OnlineBookStore.payload.userDto;
import com.OnlineBookStore.OnlineBookStore.payload.userResponse;

import java.util.List;

public interface userService {

    public userResponse createUser(userDto userDto);

    public userResponse getUserById(Long userId);

    public List<userResponse> getAllusers();

    public String deleteUser(Long userId);
}
