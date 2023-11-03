package com.example.demo_socket_context.repository;

import com.example.demo_socket_context.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepo extends JpaRepository<Account , Integer> {
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
}
