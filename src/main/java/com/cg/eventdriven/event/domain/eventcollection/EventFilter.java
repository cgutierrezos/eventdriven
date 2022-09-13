/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventcollection;

import com.cg.eventdriven.event.domain.Event;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <E>
 */
public class EventFilter<E extends Event> {
    
    public interface FilterCallback<E extends Event> {
        public boolean filter(E event);
    }
    
    private final Collection<E> events;

    public EventFilter(Collection<E> events) {
        this.events = events;
    }
    
    public EventCollection<E> findMany(FilterCallback<E> callback) {
        
        EventCollection<E> filteredEvents = new EventCollection<>();
        
        for (E event : this.events) {
            if(callback.filter(event)){
                filteredEvents.add(event);
            }
        }
        
        return filteredEvents;
        
    }
    
    public E findOne(FilterCallback<E> callback) {
        
        for (E event : this.events) {
            if(callback.filter(event)){
                return event;
            }
        }
        
        return null;
        
    }
}
