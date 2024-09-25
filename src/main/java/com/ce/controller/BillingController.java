package com.ce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.dto.BillDetails;
import com.ce.service.BillingService;

@RestController
@RequestMapping("/api")
public class BillingController {

	@Autowired
	BillingService service;

	@GetMapping
	public String application() {
		return "app is up & running.";
	}

	@PostMapping("/calculate")
	public double calculate(@RequestBody BillDetails billDetails) {
		double res = service.calculate(billDetails);
		return res;
	}
}
