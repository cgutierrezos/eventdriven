/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventconsumercollection;

import com.cg.eventdriven.event.domain.EventConsumer;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 * @param <C>
 */
public class EventConsumerIterator<C extends EventConsumer> {
    
    public interface EachCallback<C extends EventConsumer>{
        public void each(C consumer);
    }
    private final Iterator<C> iterator;

    public EventConsumerIterator(Collection<C> consumers) {
        this.iterator = consumers.iterator();
    }
    
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
    
    public C next(){ 
        if(!this.hasNext()){
            return null;
        }
        
        return this.iterator.next();
    }
    
    
    public void each(EachCallback<C> callback){
        while (this.hasNext()) {
            callback.each(this.next());
        }
    }
    
}
