/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventcollection;

import com.cg.eventdriven.event.domain.Event;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 * @param <E>
 */
public class EventIterator<E extends Event> {
    
    public interface EachCallback<E extends Event> {
        public void each(E event);
    }

    private final Iterator<E> iterator;

    public EventIterator(Collection<E> events) {
        this.iterator = events.iterator();
    }
    
    public boolean hasNext(){
        return this.iterator.hasNext();
    }
    
    public E next() {
        if(!this.hasNext()){
            return null;
        }
        
        return this.next();
    }
    
    public void each(EachCallback<E> callback){
        while (this.hasNext()) {
            callback.each(this.next());
        }
    }
    
}
