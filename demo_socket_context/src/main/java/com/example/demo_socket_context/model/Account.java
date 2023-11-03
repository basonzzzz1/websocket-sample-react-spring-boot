package com.example.demo_socket_context.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String image;
    @OneToMany
    private List<Message> fromUserMessagesList;
    @OneToMany
    private List<Message> toUserMessagesList;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Message> getFromUserMessagesList() {
        return fromUserMessagesList;
    }

    public void setFromUserMessagesList(List<Message> fromUserMessagesList) {
        this.fromUserMessagesList = fromUserMessagesList;
    }

    public List<Message> getToUserMessagesList() {
        return toUserMessagesList;
    }

    public void setToUserMessagesList(List<Message> toUserMessagesList) {
        this.toUserMessagesList = toUserMessagesList;
    }
}