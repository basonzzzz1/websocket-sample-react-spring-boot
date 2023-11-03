package com.example.demo_socket_context.service.Iservice;

import com.example.demo_socket_context.model.Message;

import java.util.List;

public interface IMessageService extends IService<Message>{
    List<Message> initialStateAllChatFriends(int loggedInUserId);
    List<Message> getAllMessages(String loggedInUsername, int chatUserId);
}
