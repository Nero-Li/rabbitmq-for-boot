package com.lyming.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/16 2:12 下午
 **/
@Configuration
public class RabbitConfig {
    //定义三个交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("Direct_Exchange");
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("Topic_Exchange");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("Fanout_Exchange");
    }
    //定义四个队列

    @Bean
    public Queue firstQueue(){
        return new Queue("FIRST_QUEUE");
    }
    @Bean
    public Queue secondQueue(){
        return new Queue("SECOND_QUEUE");
    }
    @Bean
    public Queue thirdQueue(){
        return new Queue("THIRD_QUEUE");
    }
    @Bean
    public Queue fourthQueue() {
        return new Queue("FOURTH_QUEUE");
    }

    //定义四个绑定关系
    @Bean
    public Binding bindingFirst(@Qualifier("firstQueue") Queue queue,
                                @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("first.key");
    }
    @Bean
    public Binding bindingSecond(@Qualifier("secondQueue") Queue queue,
                                @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("*.second.key");
    }
    @Bean
    public Binding bindingThird(@Qualifier("thirdQueue") Queue queue,
                                @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFourth(@Qualifier("fourthQueue") Queue queue,
                                @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
