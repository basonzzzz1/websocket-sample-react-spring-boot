package com.example.demo_socket_context.model.DTO;

import com.sun.istack.NotNull;

public class MessageCreateBindingModel {
    private int toUserId;
    private String content;

    public MessageCreateBindingModel() {
    }

    @NotNull
    public int getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    @NotNull
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}