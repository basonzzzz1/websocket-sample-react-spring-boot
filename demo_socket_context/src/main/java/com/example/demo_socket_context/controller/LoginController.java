package com.example.demo_socket_context.controller;

import com.example.demo_socket_context.model.Account;
import com.example.demo_socket_context.repository.IAccountRepo;
import com.example.demo_socket_context.service.Iservice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {
     @Autowired
     private IAccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account user) {
        List<Account> accounts = accountService.getAll();
        for (int i = 0; i < accounts.size(); i++) {
            if(accountService.findByUsernameAndPassword(user.getUsername() , user.getPassword()) != null){
                return ResponseEntity.ok(accountService.findByUsernameAndPassword(user.getUsername() , user.getPassword()));
            }
        }
        throw new RuntimeException("cặc !");
    }
    @PostMapping("/fail")
    public String checkUser(@RequestBody Account user) { // login fail
        return checkErr(user);
    }

    public String checkErr(Account user) {
        String err = "";
        if (accountService.findByUsername(user.getUsername()) != null) {
            if (accountService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null) {
                err = "wrong password";
            }
        } else {
            err = "wrong username";
        }
        return err;
    }
}