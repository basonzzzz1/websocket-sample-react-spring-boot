package com.example.demo_socket_context.controller;

import com.example.demo_socket_context.model.Account;
import com.example.demo_socket_context.service.Iservice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    private IAccountService accountService;
    @PostMapping("/register")
    public ResponseEntity<Account> createUser(@RequestBody Account user) {
        List<Account> accountList = accountService.getAll();
        boolean isUserExists = accountList.stream()
                .anyMatch(account -> account.getUsername().equals(user.getUsername()));
        if (isUserExists) {
            throw new RuntimeException("Tên người dùng đã tồn tại");
        }
        return new ResponseEntity<>(accountService.save(user), HttpStatus.CREATED);
    }

}