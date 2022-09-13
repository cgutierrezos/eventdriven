/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package eventbus.amqpeventbus;

import com.cg.eventdriven.eventbus.infra.amqpeventbus.RabbitAmqpEventBus;
import com.github.javafaker.Faker;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import event.EventChecker;
import event.TestEvent;
import event.TestEventBuilder;
import event.TestEventConsumer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cristian b
 */
public class RabbitAmqpEventBusTest {
    
    private final Faker fakeer;
    private final TestEventBuilder builder;
    
    public RabbitAmqpEventBusTest() {
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
    public void consume() throws IOException, TimeoutException, InterruptedException{
        ConnectionFactory factory =  new ConnectionFactory();
        
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        
        Connection connection = factory.newConnection();
        
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        
        RabbitAmqpEventBus eventBus = new RabbitAmqpEventBus(channel);
        eventBus.boot();
        
        TestEvent event = this.builder.build();
        
        EventChecker checker = new EventChecker(event);
        TestEventConsumer consumer = new TestEventConsumer(checker);
        
        eventBus.subscribe(consumer);
        eventBus.publish(event);
       
        Awaitility
                .await()
                .atMost(101, TimeUnit.MILLISECONDS)
                .until(checker::isChecked);
        
        
    }
    
    @Test 
    public void unsubscribe() throws IOException, TimeoutException{
        ConnectionFactory factory =  new ConnectionFactory();
        
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        
        Connection connection = factory.newConnection();
        
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        
        RabbitAmqpEventBus eventBus = new RabbitAmqpEventBus(channel);
        eventBus.boot();
        
        TestEvent event = this.builder.build();
        
        EventChecker checker = new EventChecker(event);
        TestEventConsumer consumer = new TestEventConsumer(checker);
        
        eventBus.subscribe(consumer);
        eventBus.unsubscribe(consumer);
        
        eventBus.publish(event);
       
        Awaitility
                .await()
                .atMost(101, TimeUnit.MILLISECONDS);
        
        assertTrue(!checker.isChecked());
                
        
    }
}
