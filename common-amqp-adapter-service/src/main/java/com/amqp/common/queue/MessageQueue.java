package com.amqp.common.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david
 */
@Configuration
public class MessageQueue {

    @Bean
    public Queue createQueue(String queueName) {
        return new Queue(queueName, false);
    }

}
