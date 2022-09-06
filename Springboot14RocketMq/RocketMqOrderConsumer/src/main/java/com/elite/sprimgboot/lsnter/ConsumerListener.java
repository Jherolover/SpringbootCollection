package com.elite.sprimgboot.lsnter;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "order-topic",consumerGroup = "my-consumer-group")
@Slf4j
public class ConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String orderInfo) {
        System.out.println(orderInfo);
    }
}
