/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpconsumer;

import com.cg.eventdriven.event.domain.EventConsumer;
import com.cg.eventdriven.event.domain.eventconsumercollection.EventConsumerCollection;
import com.cg.eventdriven.event.domain.eventconsumercollection.EventConsumerFilter;
import com.cg.eventdriven.event.domain.eventconsumercollection.EventConsumerIterator;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions.QueueDeclareException;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.RabbitAmqpEventBus;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions.EventBindException;
import com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions.EventUnbindException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian b
 */
public class RabbitAmqpConsumer {

    private final EventConsumerCollection consumers;
    private final Channel channel;
    private final String queueName;
    private final String exchangeName;

    public RabbitAmqpConsumer(Channel channel, String queueName, String exchangeName) {
        this.consumers = new EventConsumerCollection();
        this.channel = channel;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
    }
    
    
    
    public void subscibe(EventConsumer consumer) {
        EventConsumerFilter filter = this.consumers.filter();
        
        if(filter.findOneBySubscription(consumer.subscribeTo()) != null){
            return;
        }
        
        String routingKey = consumer.subscribeTo();
        boolean autoAck = false;
        
        try {
            this.channel.queueBind(this.queueName, this.exchangeName, routingKey);
            this.channel.basicConsume(this.queueName, autoAck, routingKey, this.consumerCallback(consumer));
        } catch (IOException ex) {
            throw new EventBindException(routingKey);
        }
    }

    
    public void unsubscribe(EventConsumer consumer) {
        
        String routingKey = consumer.subscribeTo();
        
        try {
            this.channel.basicCancel(routingKey);
            this.consumers.remove(consumer);
        } catch (IOException ex) {
            throw new EventUnbindException(routingKey);
        }
    }

    
    public void unsubscribeAll() {
        EventConsumerIterator iterator = this.consumers.iterator();
        
        while (iterator.hasNext()) {
            this.unsubscribe(iterator.next());
        }
    }
    
    public void boot() {
        boolean durable = true;
        boolean exclusive = false;
        boolean autoDelete = false;
        try {
            this.channel.queueDeclare(this.queueName, durable, exclusive, autoDelete, null);
        } catch (IOException ex) {
            throw new QueueDeclareException(this.queueName);
        }
    }
    
    private DefaultConsumer consumerCallback(EventConsumer consumer) throws IOException {
        
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                throws IOException
            {
                long deliveryTag = envelope.getDeliveryTag();
                consumer.acept(body);
                channel.basicAck(deliveryTag, false);
            }
        };
    }
    
}
