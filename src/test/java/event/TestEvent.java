/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import com.cg.eventdriven.event.domain.EventHeader;
import java.io.Serializable;

/**
 *
 * @author cristian b
 */
public class TestEvent extends com.cg.eventdriven.event.domain.Event implements Serializable{

    private final TestEventMessage message;
    
    public TestEvent(EventHeader header, TestEventMessage message){
        super(header);
        
        this.message = message;
    }
    
    @Override
    public String eventName() {
        return "tested";
    }
    
    public String getFoo() {
        return this.message.getFoo();
    }
}
