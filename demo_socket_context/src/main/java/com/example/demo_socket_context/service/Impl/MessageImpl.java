package com.example.demo_socket_context.service.Impl;

import com.example.demo_socket_context.model.Account;
import com.example.demo_socket_context.model.Message;
import com.example.demo_socket_context.repository.IAccountRepo;
import com.example.demo_socket_context.repository.IMessageRepo;
import com.example.demo_socket_context.service.Iservice.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageImpl implements IMessageService {
    @Autowired
    IMessageRepo messageRepo;
    @Autowired
    IAccountRepo accountRepo;
    @Override
    public List<Message> initialStateAllChatFriends(int loggedInUserId) {
        return messageRepo.initialStateAllChatFriends(loggedInUserId);
    }

    @Override
    public List<Message> getAllMessages(String loggedInUsername, int chatUserId) {
        Account loggedUser = accountRepo.findByUsername(loggedInUsername);
        Account chatUser = accountRepo.findById(chatUserId).get();
        return messageRepo.findAllMessagesBetweenTwoUsers(loggedUser.getId() , chatUser.getId());
    }

    @Override
    public Message save(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message edit(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public void delete(int id) {
       messageRepo.deleteById(id);
    }

    @Override
    public Message findById(int id) {
        return messageRepo.findById(id).get();
    }

    @Override
    public List<Message> getAll() {
        return messageRepo.findAll();
    }
}