package com.egabi.usermanagement.controller;

import com.egabi.usermanagement.model.BaseResponse;
import com.egabi.usermanagement.model.User;
import com.egabi.usermanagement.service.UserServices;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Api("User Services")
public class UsersController {

    private final UserServices userServices;

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(new BaseResponse(true,null,userServices.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(new BaseResponse(true,null,userServices.getUserById(id)));
    }
}
