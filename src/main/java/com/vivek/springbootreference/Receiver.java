package com.vivek.springbootreference;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver{
	private static final Logger log = LoggerFactory.getLogger(Receiver.class);
	
	private CountDownLatch latch;
	
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
        latch.countDown();
    }
}