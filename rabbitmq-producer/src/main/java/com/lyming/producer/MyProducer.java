package com.lyming.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyProducer
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 5:18 下午
 **/
@Component
public class MyProducer {

    /**或者AmqpTemplate*/
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String DIRECT_EXCHANGE = "Direct_Exchange";
    private final String TOPIC_EXCHANGE = "Topic_Exchange";
    private final String FANOUT_EXCHANGE = "Fanout_Exchange";
    public void send() {
        /*发送4条消息*/
        rabbitTemplate.convertAndSend(DIRECT_EXCHANGE,"first.key","我是一条DirectExchange消息");

        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"haha.second.key","我是一条TopicExchange消息==>haha");
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"xixi.second.key","我是一条TopicExchange消息==>xixi");

        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE,"","我是一条FanoutExchange消息");
    }
}
