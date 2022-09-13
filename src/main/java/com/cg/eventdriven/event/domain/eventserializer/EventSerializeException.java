/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventserializer;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public class EventSerializeException extends RuntimeException {

    public EventSerializeException(Event event) {
        super(String.format("Event [ %s ] can not be serialized", event.getClass().getSimpleName()));
    }
    
    
}
