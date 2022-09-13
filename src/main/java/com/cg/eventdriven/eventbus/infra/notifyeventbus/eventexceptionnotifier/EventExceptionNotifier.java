/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.notifyeventbus.eventexceptionnotifier;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public interface EventExceptionNotifier {
    
    public void notify(Exception e, Event event);
}
