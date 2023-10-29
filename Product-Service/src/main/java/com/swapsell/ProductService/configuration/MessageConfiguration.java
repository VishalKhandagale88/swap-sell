package com.swapsell.ProductService.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    public static final String queueName1 = "swap-sell-user-service-queue";
    public static final String exchangeName2 = "second-service-exchange";
    public static final String routingKey2 = "second-service-routing-key";

}
