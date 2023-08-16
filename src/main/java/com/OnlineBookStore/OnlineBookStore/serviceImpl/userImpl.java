package com.OnlineBookStore.OnlineBookStore.serviceImpl;

import com.OnlineBookStore.OnlineBookStore.entity.userEntity;
import com.OnlineBookStore.OnlineBookStore.exceptions.userNotFoundException;
import com.OnlineBookStore.OnlineBookStore.payload.userDto;
import com.OnlineBookStore.OnlineBookStore.payload.userResponse;
import com.OnlineBookStore.OnlineBookStore.service.userService;
import com.OnlineBookStore.OnlineBookStore.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userImpl implements userService {

    @Autowired
    private userRepo userRepo;
    @Override
    public userResponse createUser(userDto userDto) {
        userEntity user = new userEntity();
        userResponse response = new userResponse();
            user.setUserName(userDto.getUserName());
            user.setUserPassword(userDto.getPassword());
            user.setUserRole(userDto.getRole());
        userEntity save = userRepo.save(user);
        response.setUserId(save.getUserId());
        response.setUserName(save.getUserName());
        response.setRole(save.getUserRole());

        return response;

    }

    @Override
    public userResponse getUserById(Long userId) {
        userResponse response = new userResponse();
        Optional<userEntity> userById = userRepo.findById(userId);
        if(userById.isPresent()){
            response.setUserId(userById.get().getUserId());
            response.setUserName(userById.get().getUserName());
            response.setRole(userById.get().getUserRole());
            return response;
        }
        else {
            throw new userNotFoundException(userId);
        }

    }

    @Override
    public List<userResponse> getAllusers() {
        List<userEntity> getAllUsersList = userRepo.findAll();
        List<userResponse> userResponses = new ArrayList<>();

        for(userEntity user: getAllUsersList){
            userResponses.add(convertEntityToResponse(user));
        }

        return userResponses;

    }

    @Override
    public String deleteUser(Long userId) {
        Optional<userEntity> byId = userRepo.findById(userId);
        if (byId.isPresent()){
            userRepo.deleteById(userId);
            return "Deleted User";
        }
        return "Unable to Delete";
    }

    public userResponse convertEntityToResponse(userEntity user){
        userResponse response = new userResponse();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setRole(user.getUserRole());

        return response;
    }
}
