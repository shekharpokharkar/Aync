package com.seleniumExample.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrederFulfillmentService {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private PaymentService paymentService;

	public Order processOrder(Order order) throws InterruptedException {

		order.setTrackingId(UUID.randomUUID().toString());

		if (inventoryService.checkProductAvailability(order.getProductId())) {
			paymentService.processPayment(order);
		} else {
			throw new RuntimeException("Technical issue please retry");
		}
		return order;
	}

	@Async("asyncTaskExecutor")
	public void notifyUser(Order order) throws InterruptedException {
		Thread.sleep(4000L);
		System.out.println("Notidied user:" + Thread.currentThread().getName());

	}

	@Async("asyncTaskExecutor")
	public void assignVendor(Order order) throws InterruptedException {
		Thread.sleep(5000L);
		System.out.println("Assign To Vendor:" + Thread.currentThread().getName());
	}

	@Async("asyncTaskExecutor")
	public void packaging(Order order) throws InterruptedException {
		Thread.sleep(10000L);
		System.out.println("order packaging Completed:" + Thread.currentThread().getName());

	}

	@Async("asyncTaskExecutor")
	public void assignDeliveryPartner() throws InterruptedException {
		Thread.sleep(10000L);
		System.out.println("Delivery Partner assigned" + Thread.currentThread().getName());
	}

	@Async("asyncTaskExecutor")
	public void assignTrailerAndDispatch(Order order) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("Trailer assign And Order Dispatch" + Thread.currentThread().getName());
	}
}
