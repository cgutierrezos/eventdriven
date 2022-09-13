/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventconsumercollection;

import com.cg.eventdriven.event.domain.EventConsumer;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <C>
 */
public class EventConsumerCollection<C extends EventConsumer> {
    
    private final Collection<C> consumers;

    public EventConsumerCollection() {
        this.consumers = new ArrayList<>();
    }

    protected EventConsumerCollection(Collection<C> consumers) {
        this.consumers = consumers;
    }
    
    public void add(C consumer){
        this.consumers.add(consumer);
    }
    
    public void remove(C consumerToRemove){
        this.consumers.removeIf((C consumer) -> 
                consumerToRemove.subscribeTo().equals(consumer.subscribeTo())
        );
    }
    
    public void removeAll(){
        this.consumers.clear();
    }
    
    public EventConsumerIterator<C> iterator() {
        return new EventConsumerIterator<>(this.consumers);
    }
    
    public EventConsumerFilter<C> filter() {
        return new EventConsumerFilter<>(this.consumers);
    }
}
