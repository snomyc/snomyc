package com.snomyc.base.mq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.snomyc.base.mq.RabbitConfig;
import com.snomyc.sys.bean.User;

@Component
public class TopicRabbitAmazonConsumer {
	  private Logger logger = LoggerFactory.getLogger("AmazonRabbitmq");
	  
	  private static int num=0;
	  
	  @RabbitListener(queues = {RabbitConfig.topic_amazon})
	  @RabbitHandler
	  public void handleMessage(Message message){
		  try {
			  num=num+1;
			  logger.info("消息队列开始消费 ....");
			  User user = JSONObject.parseObject(message.getBody(),User.class);
			  logger.error("接收:{}",user.getUserName());
			  logger.error("开始消费推送信息队列数据："+JSONObject.toJSONString(user));
			  logger.info("消息队列完成消费..."+num);
		  }catch (Exception e) {
			  throw new RuntimeException("处理消息队列报错");
		  }
	  }
}


