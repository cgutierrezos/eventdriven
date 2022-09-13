/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.localeventbus;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.event.domain.EventConsumer;
import com.cg.eventdriven.event.domain.eventconsumercollection.EventConsumerCollection;
import com.cg.eventdriven.event.domain.eventconsumercollection.EventConsumerFilter;
import com.cg.eventdriven.eventbus.domain.EventBus;

/**
 *
 * @author cristian b
 */
public class LocalEventBus implements EventBus {

    private final EventConsumerCollection consumers;

    public LocalEventBus() {
        this.consumers = new EventConsumerCollection();
    }
    
    
    @Override
    public void subscribe(EventConsumer consumer) {
        this.consumers.add(consumer);
    }

    @Override
    public void unsubscribe(EventConsumer consumer) {
        this.consumers.remove(consumer);
    }

    @Override
    public void unsubscribeAll() {
        this.consumers.removeAll();
    }

    @Override
    public void publish(Event event) {
        EventConsumer consumer = this.findConsumerByEvent(event);
        
        this.throwIfConsumerNotFound(consumer, event);
        
        this.consume(consumer, event);
        
    }
    
    private void consume(EventConsumer consumer, Event event){
        consumer.acept(event.serialize());
    }
    
    private EventConsumer findConsumerByEvent(Event event){
        EventConsumerFilter filter = this.consumers.filter();
        
        return filter.findOneBySubscription(event.getClass().getSimpleName());
    }

    

    @Override
    public void boot() {
        // Boot not needed
    }
    
    private void throwIfConsumerNotFound(EventConsumer consumer, Event event) {
        if(consumer == null){
            throw new EventConsumerNotFoundException(event);
        }
    }
    
}
