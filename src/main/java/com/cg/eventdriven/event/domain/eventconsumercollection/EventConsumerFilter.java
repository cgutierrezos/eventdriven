/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventconsumercollection;

import com.cg.eventdriven.event.domain.EventConsumer;
import com.cg.eventdriven.event.domain.eventcollection.EventCollection;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <C>
 */
public class EventConsumerFilter<C extends EventConsumer> {
    
    public interface FilterCallback<C extends EventConsumer> {
        public boolean filter(C consumer);
    }
    private final Collection<C> consumers;

    public EventConsumerFilter(Collection<C> consumers) {
        this.consumers = consumers;
    }
    
    
    public C findOneBySubscription(String subscription){
        return this.findOne((C consumer) -> 
                consumer.subscribeTo().equals(subscription)
        );
    }
    
    
    public C findOne(FilterCallback<C> callback){
        
        for (C consumer : this.consumers) {
            if(callback.filter(consumer)){
                return consumer;
            }
        }
        
        return null;
    }
    
    public EventConsumerCollection<C> findMany(FilterCallback<C> callback){
        
        EventConsumerCollection<C> filteredConsumers = new EventConsumerCollection<>();
        
        for (C consumer : this.consumers) {
            if(callback.filter(consumer)){
                filteredConsumers.add(consumer);
            }
        }
        
        return filteredConsumers;
    }
    
}
