/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import com.cg.eventdriven.event.domain.EventHeader;
import com.cg.eventdriven.event.domain.eventcollection.EventCollection;
import com.cg.eventdriven.event.domain.eventvo.EventIDVO;
import com.github.javafaker.Faker;

/**
 *
 * @author cristian b
 */
public class TestEventBuilder {
    
    private final Faker faker;

    public TestEventBuilder(Faker faker) {
        this.faker = faker;
    }
    
    public TestEvent build() {
        
        EventHeader header = new EventHeader(new EventIDVO(this.faker.internet().uuid()));
        TestEventMessage message = new TestEventMessage(this.faker.lorem().word());
                
        return new TestEvent(header, message);
    }
    
    public EventCollection<TestEvent> build(int number){
        
        EventCollection<TestEvent> events = new EventCollection<>();
        
        for (int i = 0; i < number; i++) {
            events.add(this.build());
        }
        
        return events;
    }
}
