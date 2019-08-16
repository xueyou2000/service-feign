package com.xueyou.study.servicefeign.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 创建 by xueyo on 2019/8/16
 */
@Component
public class FeignConsumer {

    private static Logger log = LoggerFactory.getLogger(FeignConsumer.class);


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topic-exchange", type = ExchangeTypes.TOPIC),
            value = @Queue(value = "wechat-queue-c", durable = "true"),
            key = "other.login.#"
    ))
    public void directWechatLogin(String msg) {
        log.info("多播 wechat-queue-c 队列 匹配路径 other/login/# 接受消息: -----[{}]-----\n", msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topic-exchange", type = ExchangeTypes.TOPIC),
            value = @Queue(value = "wechat-queue-d", durable = "true"),
            key = "other.#"
    ))
    public void directWechatExit(String msg) {
        log.info("多播 wechat-queue-d 队列 匹配路径 other/# 接受消息: -----[{}]-----\n", msg);
    }


}