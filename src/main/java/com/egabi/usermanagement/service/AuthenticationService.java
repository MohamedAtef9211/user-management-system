package com.egabi.usermanagement.service;

import com.egabi.usermanagement.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServices userServices;

    public User login(String email , String password){
        return userServices.getUserByEmail(email);
    }
}
