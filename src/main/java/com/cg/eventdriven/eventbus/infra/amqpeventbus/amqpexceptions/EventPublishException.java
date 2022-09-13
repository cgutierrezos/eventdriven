/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public class EventPublishException extends RuntimeException {

    public EventPublishException(Event event) {
        super(String.format("Event [ %s ] can not be published", event.eventName()));
    }
    
    
}
