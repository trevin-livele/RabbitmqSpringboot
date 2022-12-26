package com.trevin.rabbitmqspringboot.consumer;


import com.trevin.rabbitmqspringboot.model.QueueObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerConsumer {

    @RabbitListener(queues = {"${rabbitmq.direct.queue-1}", "${rabbitmq.direct.queue-2}"},
    containerFactory = "listenerContainerFactory")

    public void receiveMessage(QueueObject object){
        System.out.println(object);
    }
}
