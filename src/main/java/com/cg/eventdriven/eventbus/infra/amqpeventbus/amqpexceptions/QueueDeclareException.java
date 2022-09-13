/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions;

/**
 *
 * @author cristian b
 */
public class QueueDeclareException extends RuntimeException {

    public QueueDeclareException(String queueName) {
        super(String.format("Queue [ %s ] can not be declared", queueName));
    }
    
    
    
}
