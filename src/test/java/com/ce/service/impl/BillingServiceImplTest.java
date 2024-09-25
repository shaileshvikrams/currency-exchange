package com.ce.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

public class BillingServiceImplTest {

	@InjectMocks
	private BillingServiceImpl billingService;

	@Mock
	Logger logger;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculate() {
//		BillDetails billDetails = new BillDetails();
//		when(billingService.calculateDiscount(billDetails)).thenReturn(Double.valueOf(55));
//
//		double res = billingController.calculate(billDetails);
//		assertEquals(-55.0, res);
	}

}
