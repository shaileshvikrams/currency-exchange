package com.ce.service;

import com.ce.dto.BillDetails;

public interface BillingService {

	double calculate(BillDetails billDetails);

	double calculateDiscount(BillDetails billDetails);
}
