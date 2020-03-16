package com.lyming.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FirstConsumer
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 3:06 下午
 **/
@Component
@RabbitListener(queues = "FIRST_QUEUE")
public class FirstConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("=================");
        System.out.println("First Consumer Received msg : " + msg +"==>Listening From FIRST_QUEUE");
        System.out.println("=================");
    }
}
