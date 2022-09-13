/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.notifyeventbus;

import com.cg.eventdriven.event.domain.Event;
import com.cg.eventdriven.event.domain.EventConsumer;
import com.cg.eventdriven.eventbus.domain.EventBus;
import com.cg.eventdriven.eventbus.infra.notifyeventbus.eventexceptionnotifier.EventExceptionNotifier;
import com.cg.eventdriven.eventbus.infra.notifyeventbus.eventnotifier.EventNotifier;

/**
 *
 * @author cristian b
 */
public class NotifyEventBus implements EventBus {

    private final EventBus eventBus;
    private final EventNotifier notifier;
    private final EventExceptionNotifier exceptionNotifier;

    public NotifyEventBus(EventBus eventBus, EventNotifier notifier, EventExceptionNotifier exceptionNotifier) {
        this.eventBus = eventBus;
        this.notifier = notifier;
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyEventBus(EventBus eventBus, EventNotifier notifier) {
        this.eventBus = eventBus;
        this.notifier = notifier;
        this.exceptionNotifier = (Exception e, Event event) -> {};
    }
    
    
    public NotifyEventBus(EventBus eventBus, EventExceptionNotifier exceptionNotifier) {
        this.eventBus = eventBus;
        this.notifier = (Event event) -> {};
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
        this.notifier = (Event event) -> {};
        this.exceptionNotifier = (Exception e, Event event) -> {};
    }
    
    
    
    
    @Override
    public void subscribe(EventConsumer consumer) {
        this.eventBus.subscribe(consumer);
    }

    @Override
    public void unsubscribe(EventConsumer consumer) {
        this.eventBus.unsubscribe(consumer);
    }

    @Override
    public void unsubscribeAll() {
        this.eventBus.unsubscribeAll();
    }

    @Override
    public void publish(Event event) {
        try{
            this.eventBus.publish(event);
            this.notifier.notify(event);
        }catch(Exception e){
            this.exceptionNotifier.notify(e, event);
        }
    }

    @Override
    public void boot() {
        // No boot required
    }
    
}
