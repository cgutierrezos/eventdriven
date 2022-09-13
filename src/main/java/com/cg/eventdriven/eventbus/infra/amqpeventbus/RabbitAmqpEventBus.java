/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.event.domain.EventConsumer;
import com.cg.eventdriven.eventbus.domain.EventBus;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpconsumer.RabbitAmqpConsumer;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqppublisher.RabbitAmqpPublisher;
import com.rabbitmq.client.Channel;

/**
 *
 * @author cristian b
 */
public class RabbitAmqpEventBus implements EventBus {

    private final RabbitAmqpPublisher publisher;
    private final RabbitAmqpConsumer consumer;
    
    private static final String QUEUE_NAME = "Test";
    private static final String EXCHANGE_NAME = "Test";

    public RabbitAmqpEventBus(Channel channel) {
        this.publisher = new RabbitAmqpPublisher(channel, RabbitAmqpEventBus.EXCHANGE_NAME);
        this.consumer = new RabbitAmqpConsumer(channel,  RabbitAmqpEventBus.QUEUE_NAME, RabbitAmqpEventBus.EXCHANGE_NAME);
    }
    
    
    @Override
    public void subscribe(EventConsumer consumer) {
        this.consumer.subscibe(consumer);
    }

    @Override
    public void unsubscribe(EventConsumer consumer) {
        this.consumer.unsubscribe(consumer);
    }

    @Override
    public void unsubscribeAll() {
        this.consumer.unsubscribeAll();
    }

    @Override
    public void publish(Event event) {
        this.publisher.publish(event);
    }

    @Override
    public void boot() {
        this.consumer.boot();
        this.publisher.boot();   
    }
    
}
