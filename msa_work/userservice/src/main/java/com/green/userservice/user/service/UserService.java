package com.green.userservice.user.service;

import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserResponse join(UserRequest userRequest);

    LoginResponse login(String email, String password);

    public List<UserResponse> list();
}
