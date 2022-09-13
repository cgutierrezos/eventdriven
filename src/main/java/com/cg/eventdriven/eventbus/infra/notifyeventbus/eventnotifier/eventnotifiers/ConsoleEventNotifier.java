/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.notifyeventbus.eventnotifier.eventnotifiers;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.eventbus.infra.notifyeventbus.eventnotifier.EventNotifier;
import org.slf4j.Logger;

/**
 *
 * @author cristian b
 */
public class ConsoleEventNotifier implements EventNotifier {

    private final Logger logger;

    public ConsoleEventNotifier(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public void notify(Event event) {
        this.logger.debug(event.toString());
    }
    
}
