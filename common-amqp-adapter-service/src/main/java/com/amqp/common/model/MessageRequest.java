package com.amqp.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author david
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String message;
}
