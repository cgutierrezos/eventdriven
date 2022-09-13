/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.eventdriven.eventbus.domain;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.event.domain.EventConsumer;

/**
 *
 * @author cristian b
 */
public interface EventBus {
    
    public void subscribe(EventConsumer consumer);
    
    public void unsubscribe(EventConsumer consumer);
    
    public void unsubscribeAll();
    
    public void publish(Event event);
    
    public void boot();
    
}
