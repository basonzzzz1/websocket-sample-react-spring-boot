package com.example.demo_socket_context.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account fromUser;
    @ManyToOne
    private Account toUser;
    private String content;
    private LocalDateTime time;
}