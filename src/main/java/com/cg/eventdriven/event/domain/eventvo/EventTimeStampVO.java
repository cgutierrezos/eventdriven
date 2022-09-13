/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventvo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cristian b
 */
public class EventTimeStampVO implements Serializable {
    private final Date createdAt;
    private final Date updatedAt;

    public EventTimeStampVO() {
        this.createdAt = new Date();
        this.updatedAt = this.createdAt;
    }

    public EventTimeStampVO(Date createdAt, Date updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Date createdAt() {
        return this.createdAt;
    }
    
    public Date updatedAt() {
        return this.updatedAt;
    }
    
    
    public EventTimeStampVO update() {
        return new EventTimeStampVO(this.createdAt, new Date());
    }
}
