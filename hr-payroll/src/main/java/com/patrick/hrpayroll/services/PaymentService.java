package com.patrick.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.patrick.hrpayroll.entities.Payment;
import com.patrick.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker-host}")
	private String wokerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, int days) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", "" + workerId);
		
		Worker worker = restTemplate.getForObject(wokerHost + "/workers/{id}", Worker.class, pathVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
