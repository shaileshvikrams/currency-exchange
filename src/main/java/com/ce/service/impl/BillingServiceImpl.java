package com.ce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.dto.BillDetails;
import com.ce.service.BillingService;
import com.ce.service.ExchangeService;
import com.ce.utils.UserTypeEnum;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	ExchangeService exchangeService;

	@Override
	public double calculate(BillDetails billDetails) {
		double discountAmt = this.calculateDiscount(billDetails);
		double exchangePrice = exchangeService.exchangeCurrency(billDetails.getTotalAmount(),
				billDetails.getOriginalCurrency(), billDetails.getTargetCurrency());
		return (billDetails.getTotalAmount() - discountAmt) * exchangePrice;
	}

	@Override
	public double calculateDiscount(BillDetails billDetails) {
		String userType = billDetails.getUserType();
		int discountPerc = 0;
		double discountAmt = 0;
		double totalAmount = billDetails.getTotalAmount();

		if (userType.equals(UserTypeEnum.EMPLOYEE.name())) {
			discountPerc = 30;
		} else if (userType.equals(UserTypeEnum.AFFILIATE.name())) {
			discountPerc = 10;
		} else if (billDetails.getCustomerTenure() > 2) {
			discountPerc = 5;
		} else {
			discountAmt = (totalAmount / 100) * 5;
		}

		return discountAmt == 0 ? totalAmount - (totalAmount * discountPerc / 100) : discountAmt;
	}

}
