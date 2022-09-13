/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import com.cg.eventdriven.event.domain.Event;

/**
 *
 * @author cristian b
 */
public class EventChecker {
    
    private final com.cg.eventdriven.event.domain.Event event;
    private boolean checked;

    public EventChecker(Event event) {
        this.event = event;
        this.checked = false;
    }
    
    public void check(com.cg.eventdriven.event.domain.Event event){
        this.checked = this.event.eventId().equals(event.eventId());
    }

    public boolean isChecked() {
        return this.checked;
    }
    
    
}
