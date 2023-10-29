package com.swapsell.ProductService.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    public static final String queueName1 = "swap-sell-user-service-queue";
    public static final String exchangeName2 = "second-service-exchange";
    public static final String routingKey2 = "second-service-routing-key";

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey2);
    }

}
