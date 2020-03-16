package com.lyming.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThirdConsumer
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 3:29 下午
 **/
@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("=================");
        System.out.println("Third Consumer Received msg : " + msg +"==>Listening From THIRD_QUEUE");
        System.out.println("=================");
    }
}
