/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventserializer;

import java.nio.charset.Charset;

/**
 *
 * @author cristian b
 */
public class EventDeserializeException extends RuntimeException {
    
    public EventDeserializeException(byte[] bytes){
        super(String.format("Message [ %s ] can not be deserialized", new String(bytes, Charset.defaultCharset())));
    }
}
