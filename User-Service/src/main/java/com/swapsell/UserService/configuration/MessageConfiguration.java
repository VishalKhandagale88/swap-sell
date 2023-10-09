package com.swapsell.UserService.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    public static final String exchangeName1 = "swap-sell-user-service-exchange";
    public static final String queueName1 = "swap-sell-user-service-queue";
    public static final String routingKey1 = "swap-sell-user-service-routing-key";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName1);
    }

    @Bean
    public Queue queue(){
        return new Queue(queueName1);
    }
}
