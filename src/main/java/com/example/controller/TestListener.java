package com.example.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;


@Service
public class TestListener {

    @JmsListener(destination = "testmq789456")
    public void receive(Object msg) throws JMSException {
        TextMessage textMessage = (TextMessage) msg;
        System.out.println("收到消息====" + textMessage.getText());
    }


}
