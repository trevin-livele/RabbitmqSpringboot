package com.trevin.rabbitmqspringboot.controller;


import com.trevin.rabbitmqspringboot.model.QueueObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FanoutController {

    @Autowired
    private AmqpTemplate fanoutExchange;


    @PostMapping("fanout")
    public ResponseEntity<?> sendMessageWithFanoutExchange(){
        QueueObject object = new QueueObject("fanout", LocalDateTime.now());
        fanoutExchange.convertAndSend(object);

        return ResponseEntity.ok(true);
    }
}
