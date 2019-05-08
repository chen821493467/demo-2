package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;


@Service("testProducer")
public class TestProducer {

    @Autowired
//    private JmsTemplate jmsTemplate;
    private JmsMessagingTemplate jmsTemplate;

    public void sendMessage(String name, Object msg) {
//        ActiveMQQueue mqQueue = new ActiveMQQueue(name);
        jmsTemplate.convertAndSend("testmq789456", msg);
    }

}
