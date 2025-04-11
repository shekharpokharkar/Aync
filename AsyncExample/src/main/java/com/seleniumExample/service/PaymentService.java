package com.seleniumExample.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public void processPayment(Order order) throws InterruptedException {
		System.out.println("Initiate Payment For Order:" + order.getProductId());
		Thread.sleep(2000L);
		System.out.println("Completed Payment For Order:" + order.getProductId());

	}

}
