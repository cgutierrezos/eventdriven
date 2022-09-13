/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventcollection;

import com.cg.eventdriven.event.domain.Event;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <E>
 */
public class EventCollection<E extends Event> {
    
    private final Collection<E> events;

    public EventCollection() {
        this.events = new ArrayList<>();
    }

    protected EventCollection(Collection<E> events) {
        this.events = events;
    }
    
    public void add(E event){
        this.events.add(event);
    }
    
    public void remove(E eventToRemove){
        this.events.removeIf((E event) ->             
                eventToRemove.eventId().equals(event.eventId())
        );
    }
    
    public EventIterator<E> iterator() {
        return new EventIterator<>(this.events);
    }
    
    public EventFilter<E> filter() {
        return new EventFilter<>(this.events);
    }
}
