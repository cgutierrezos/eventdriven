/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import com.cg.eventdriven.event.domain.EventConsumer;

/**
 *
 * @author cristian b
 */
public class TestEventConsumer extends EventConsumer<TestEvent>{

    private final EventChecker checker;
    
    public TestEventConsumer(EventChecker checker){
        this.checker = checker;
    }
    
    @Override
    public String subscribeTo() {
        return "tested";
    }

    @Override
    protected void consume(TestEvent event) {
        this.checker.check(event);
        System.out.println(String.format("Foo: [ %s ]", event.getFoo()));
    }
    
    
    
}
