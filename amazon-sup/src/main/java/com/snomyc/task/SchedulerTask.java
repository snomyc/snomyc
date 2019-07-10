package com.snomyc.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.snomyc.base.mq.RabbitConfig;
import com.snomyc.base.mq.producer.BaseRabbitSend;
import com.snomyc.base.mq.producer.BaseRabbitTemplate;
import com.snomyc.sys.bean.User;


@Component
public class SchedulerTask {
	
	private Logger logger = LoggerFactory.getLogger("AmazonRabbitmq");
	
//	@Autowired
//    private AmqpTemplate rabbitTemplate;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private BaseRabbitTemplate rabbitMqConfig;
	
	private int count=0;

    @Scheduled(cron="0 */6 * * * ?")
    private void process(){
    	User user = new User();
    	user.setUserName("你是大傻逼! 加"+(count++));
    	logger.error(JSONObject.toJSONString(user));
        BaseRabbitSend.convertAndTopicSend(RabbitConfig.exchange_amazon, RabbitConfig.topic_amazon, user, rabbitMqConfig);
    }
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 
    @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
    @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
    @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
     * 方法说明:
    
     * 创立日期:2018年6月1日 下午5:38:02
     * 创建人:yangcan
    
     */
    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        User user = new User();
    	user.setUserName("你是大傻逼! 加加"+(count++));
    	logger.error(JSONObject.toJSONString(user));
        this.rabbitTemplate.convertAndSend(RabbitConfig.exchange_amazon, RabbitConfig.topic_amazon, user);
    }
}
