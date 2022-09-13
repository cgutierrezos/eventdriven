/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.notifyeventbus.eventexceptionnotifier;

import com.cg.eventdriven.event.domain.Event;
import org.slf4j.Logger;

/**
 *
 * @author cristian b
 */
public class ConsoleEventExceptionNotifier implements EventExceptionNotifier{

    private final Logger logger;

    public ConsoleEventExceptionNotifier(Logger logger) {
        this.logger = logger;
    }
    
    
    @Override
    public void notify(Exception e, Event event) {
        this.logger.error(e.toString());
        this.logger.debug(event.toString());
    }
    
}
