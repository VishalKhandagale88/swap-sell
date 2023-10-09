package com.swapsell.AuthenticationService.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageBusConfiguration {
    public static final String exchangeName1 = "swap-sell-user-service-exchange";
    public static final String queueName1 = "swap-sell-user-service-queue";
    public static final String routingKey1 = "swap-sell-ser-service-routing-key";
    @Bean
    @Primary
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName1);
    }
    @Bean
    public Queue queue(){
        return new Queue(queueName1);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey1);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
