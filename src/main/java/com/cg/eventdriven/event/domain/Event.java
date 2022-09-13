/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain;

import com.cg.eventdriven.event.domain.eventserializer.EventSerializer;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cristian b
 */
public abstract class Event implements Serializable {
    
    private final EventHeader header;
    private final EventSerializer serializer;

    protected Event(EventHeader header) {
        this.header = header;
        this.serializer = new EventSerializer();
    }
    
    public abstract String eventName();
    
    public String eventId() {
        return this.header.id();
    }
    
    public Date eventCreatedAt(){
        return this.header.createdAt();
    }
    
    public Date eventUpdatedAt() {
        return this.header.updatedAt();
    }
    
    public void update() {
        this.header.update();
    }
    
    public byte[] serialize() {
        return this.serializer.serialize(this);
    }
    
}
