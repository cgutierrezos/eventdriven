/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain;

import com.cg.eventdriven.event.domain.eventvo.EventIDVO;
import com.cg.eventdriven.event.domain.eventvo.EventTimeStampVO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cristian b
 */
public class EventHeader implements Serializable {
    
    private final EventIDVO idVO;
    private EventTimeStampVO timeStampVO;

    public EventHeader(EventIDVO idVO, EventTimeStampVO timeStampVO) {
        this.idVO = idVO;
        this.timeStampVO = timeStampVO;
    }

    public EventHeader(EventIDVO idVO) {
        this.idVO = idVO;
        this.timeStampVO = new EventTimeStampVO();
    }
    
    public String id() {
        return this.idVO.id();
    }
    
    public Date createdAt(){
        return this.timeStampVO.createdAt();
    }
    
    public Date updatedAt() {
        return this.timeStampVO.updatedAt();
    }
    
    public void update() {
        this.timeStampVO = this.timeStampVO.update();
    }
}
