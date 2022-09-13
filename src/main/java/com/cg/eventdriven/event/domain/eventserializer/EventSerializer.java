/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventserializer;

import com.cg.eventdriven.event.domain.Event;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author cristian b
 */
public class EventSerializer implements Serializable {

    public byte[] serialize(Event event) {
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(event);
            return bs.toByteArray();
        } catch (IOException ex) {
            throw new EventSerializeException(event);
        }
    }

    public <E extends Event> E deserialize(byte[] bytes) {

        try {
            ByteArrayInputStream bs = new ByteArrayInputStream(bytes); // bytes es el byte[]
            ObjectInputStream is = new ObjectInputStream(bs);
            is.close();
            
            return (E) is.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new EventDeserializeException(bytes);
        }
    }

}
