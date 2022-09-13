/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.eventbus.infra.amqpeventbus.amqpexceptions;

/**
 *
 * @author cristian b
 */
public class ExchangeDeclareException extends RuntimeException {

    public ExchangeDeclareException(String exchangeName) {
        super(String.format("Exchange [ %s ] can not be declared", exchangeName));
    }
    
    
}
