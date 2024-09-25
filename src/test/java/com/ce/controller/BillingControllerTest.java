package com.ce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.ce.dto.BillDetails;
import com.ce.service.BillingService;

public class BillingControllerTest {

	@Mock
	private BillingService billingService;

	@InjectMocks
	private BillingController billingController;

	@Mock
	Logger logger;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculate() {
		BillDetails billDetails = new BillDetails();
		when(billingService.calculate(billDetails)).thenReturn(Double.valueOf(55));

		double res = billingController.calculate(billDetails);
		assertEquals(55.0, res);
	}
}
