/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.notifyeventbus.eventnotifier;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public interface EventNotifier {
    
    public void notify(Event event);
}
