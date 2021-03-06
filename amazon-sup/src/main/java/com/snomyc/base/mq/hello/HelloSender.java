package com.snomyc.base.mq.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snomyc.base.mq.RabbitConfig;

import java.util.Date;

@Component
public class HelloSender {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "我是"+i+"号,正在进入队列,时间:"+ new Date();
        System.out.println("发送队列 : " + context);
        //this.rabbitTemplate.convertAndSend("hello", context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.exchange_amazon, RabbitConfig.topic_amazon, context);
        logger.info("{}AI返回的结果{}", "1", "2");
    }
}
