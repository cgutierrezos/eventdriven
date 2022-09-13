/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.localeventbus;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public class EventConsumerNotFoundException extends RuntimeException {

    public EventConsumerNotFoundException(Event event) {
        super(String.format("EventConsumer not found for Event [ %s ]", event.getClass().getSimpleName()));
    }
    
}
