/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import java.io.Serializable;

/**
 *
 * @author cristian b
 */
public class TestEventMessage implements Serializable{
    
    private final String foo;

    public TestEventMessage(String foo) {
        this.foo = foo;
    }
    
    public String getFoo() {
        return this.foo;
    }
    
}
