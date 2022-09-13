/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package event;

import com.cg.eventdriven.event.domain.eventserializer.EventSerializer;
import com.github.javafaker.Faker;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cristian b
 */
public class EventTest {
    
    private final Faker fakeer;
    private final TestEventBuilder builder;
    
    public EventTest() {
        this.fakeer = new Faker();
        this.builder = new TestEventBuilder(this.fakeer);
    
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void serialize() throws IOException {
        
        TestEvent event = this.builder.build();
        
        byte[] stream = event.serialize();
        
        assertTrue(stream.length > 0);
        
    }
    
    @Test
    public void deserialize() throws IOException, ClassNotFoundException{
        
        TestEvent event = this.builder.build();
        
        EventSerializer serializer = new EventSerializer();
        
        byte[] stream = event.serialize();
        
        TestEvent deserialized = serializer.deserialize(stream);
        
        assertTrue(event.eventId().equals(deserialized.eventId()));
        assertTrue(event.getFoo().equals(deserialized.getFoo()));
        
    }
    
    @Test
    public void consume() throws IOException{
        TestEvent event = this.builder.build();
        
        EventChecker checker = new EventChecker(event);
        TestEventConsumer consumer = new TestEventConsumer(checker);
        
        byte[] stream = event.serialize();
        
        consumer.acept(stream);
        
        assertTrue(checker.isChecked());
    }
}
