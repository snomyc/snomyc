package com.snomyc.base.mq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.snomyc.base.mq.RabbitConfig;

@Component
@RabbitListener(queues = {RabbitConfig.topic_amazon})
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("接收队列  : " + hello);
    }

}
