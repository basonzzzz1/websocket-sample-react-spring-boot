package com.example.demo_socket_context.controller;

import com.example.demo_socket_context.model.Account;
import com.example.demo_socket_context.model.Message;
import com.example.demo_socket_context.service.Iservice.IAccountService;
import com.example.demo_socket_context.service.Iservice.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@CrossOrigin("*")
public class MessageController {
    @Autowired
    IMessageService messageService;
    @Autowired
    SimpMessagingTemplate template;
    @Autowired
    IAccountService accountService;
//    hàm lấy tất cả list friend đã nhắn tin
    @GetMapping("/allFriend/{id}")
    public List<Message> getAllChatFriends(@PathVariable int id){
        return messageService.initialStateAllChatFriends(id);
    }
    //    http://localhost:8080/message/all/{id}
//    trong hàm getAllMessages @PathVariable int id sẽ là người bên kia nhắn
//    và @RequestBody Account principal sẽ là chủ thể của mình đang đăng nhập
    @PostMapping( "/all/{id}")
    public List<Message> getAllMessages(@PathVariable int id ,@RequestBody Account principal) {
        String loggedInUsername = principal.getUsername();
        return messageService.getAllMessages(loggedInUsername, id);
    }
    @PostMapping("/chat")
    public void createPrivateChatMessages( @RequestBody Message message) throws Exception {
        if(message != null ) {
            Account account = accountService.findById(message.getFromUser().getId());
            message.setTime(LocalDateTime.now());
            message.setFromUser(account);
            messageService.save(message);
            template.convertAndSend("/chat/user/queue/position-update", message);
            template.convertAndSend("/chat/user/queue/position-update", message);
            return;
        }
        throw new Exception("Error Create Message !");
    }
}