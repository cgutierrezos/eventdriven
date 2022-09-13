/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.eventdriven.event.domain.eventvo;

import java.io.Serializable;

/**
 *
 * @author cristian b
 */
public class EventIDVO implements Serializable {
    private final String id;

    public EventIDVO(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
