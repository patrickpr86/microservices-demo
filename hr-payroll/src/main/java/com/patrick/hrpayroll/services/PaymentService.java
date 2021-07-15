package com.patrick.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.patrick.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Patrick", 200.0, days);
		
	}

}
