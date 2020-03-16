package com.lyming.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecondConsumer
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 3:27 下午
 **/
@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("=================");
        System.out.println("Second Consumer Received msg : " + msg +"==>Listening From SECOND_QUEUE");
        System.out.println("=================");
    }
}
