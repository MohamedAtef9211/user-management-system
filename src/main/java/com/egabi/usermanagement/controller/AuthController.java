package com.egabi.usermanagement.controller;

import com.egabi.usermanagement.model.BaseResponse;
import com.egabi.usermanagement.service.AuthenticationService;
import com.egabi.usermanagement.service.UserServices;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String email , @RequestParam String password) {
        return ResponseEntity.ok(new BaseResponse(true,authenticationService.login(email,password)));
    }
}
