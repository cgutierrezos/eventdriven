/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.eventdriven.event.domain;

import com.cg.eventdriven.event.domain.eventserializer.EventSerializer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian b
 * @param <E>
 */
public abstract class EventConsumer<E extends Event> {
    
    private final EventSerializer serializer;

    protected EventConsumer() {
        this.serializer = new EventSerializer();
    }
    
    public abstract String subscribeTo();
    
    public void acept(byte[] message)  {
        
        E event = this.serializer.deserialize(message);
        this.consume(event);
        
    }
    
    protected abstract void consume(E event);
    
}
