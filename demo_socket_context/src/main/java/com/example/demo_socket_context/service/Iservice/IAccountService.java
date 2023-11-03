package com.example.demo_socket_context.service.Iservice;

import com.example.demo_socket_context.model.Account;

public interface IAccountService extends IService<Account>{
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
}
