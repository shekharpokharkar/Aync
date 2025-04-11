package com.seleniumExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumExample.service.Order;
import com.seleniumExample.service.OrederFulfillmentService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrederFulfillmentService service;

	@PostMapping("/")
	public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
		service.processOrder(order);
		service.notifyUser(order);
		service.assignVendor(order);
		service.packaging(order);
		service.assignDeliveryPartner();
		service.assignTrailerAndDispatch(order);
		return ResponseEntity.ok(order);
	}

}
