package com.swapsell.AuthenticationService.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBusConfiguration {
    public static final String exchangeName1 = "swap-sell-user-service-exchange";
    public static final String queueName1 = "swap-sell-user-service-queue";
    public static final String routingKey1 = "swap-sell-ser-service-routing-key";

}
