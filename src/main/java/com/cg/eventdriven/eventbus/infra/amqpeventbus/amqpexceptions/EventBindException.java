/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions;

/**
 *
 * @author cristian b
 */
public class EventBindException extends RuntimeException {

    public EventBindException(String routingKey) {
        super(String.format("RoutingKey [ %s ] can not be bind", routingKey));
    }
    
}
