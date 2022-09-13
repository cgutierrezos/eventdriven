/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqppublisher;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions.ExchangeDeclareException;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions.EventPublishException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import java.io.IOException;

/**
 *
 * @author cristian b
 */
public class RabbitAmqpPublisher {
    
    private final Channel channel;
    private final String exchangeName;

    public RabbitAmqpPublisher(Channel channel, String exchangeName) {
        this.channel = channel;
        this.exchangeName = exchangeName;
    }
    
    /**
     *
     * @param event
     */
    public void publish(Event event) {
        
        String routingKey = event.eventName();
        byte[] message = event.serialize();
        AMQP.BasicProperties properties = this.getProperties();
        
        try {
            this.channel.basicPublish(this.exchangeName, routingKey, properties, message);
        } catch (IOException ex) {
            throw new EventPublishException(event);
        }
        
    }
    
    public void boot() {
        try {            
            this.channel.exchangeDeclare(this.exchangeName, BuiltinExchangeType.TOPIC, true);
        } catch (IOException ex) {
            throw new ExchangeDeclareException(this.exchangeName);
        }
    }
    
    private AMQP.BasicProperties getProperties() {
        return new AMQP.BasicProperties.Builder()
               .contentType("text/plain")
               .deliveryMode(1)
               .priority(1)
               //.userId("bob")
               .build();
    }
}


