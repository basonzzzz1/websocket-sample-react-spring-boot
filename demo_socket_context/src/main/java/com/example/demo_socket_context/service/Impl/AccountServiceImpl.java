package com.example.demo_socket_context.service.Impl;

import com.example.demo_socket_context.model.Account;
import com.example.demo_socket_context.repository.IAccountRepo;
import com.example.demo_socket_context.service.Iservice.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepo accountRepo;
    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account edit(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public void delete(int id) {
         accountRepo.deleteById(id);
    }

    @Override
    public Account findById(int id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findByUsername(username);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return accountRepo.findByUsernameAndPassword(username,password);
    }
}