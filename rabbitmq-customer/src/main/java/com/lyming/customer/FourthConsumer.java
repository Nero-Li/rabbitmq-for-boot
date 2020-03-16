package com.lyming.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FourthConsumer
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 3:30 下午
 **/
@Component
@RabbitListener(queues = "FOURTH_QUEUE")
public class FourthConsumer {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("=================");
        System.out.println("Fourth Consumer Received msg : " + msg +"==>Listening From FOURTH_QUEUE");
        System.out.println("=================");
    }

}
