package com.patrick.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.hrpayroll.entities.Payment;
import com.patrick.hrpayroll.entities.Worker;
import com.patrick.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	// Abordagem com Rest Template esta comentada, no caso foi refatorada usando
	// Feign Client

//	@Value("${hr-worker-host}")
//	private String wokerHost;
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	public Payment getPayment(Long workerId, int days) {
//		Map<String, String> pathVariables = new HashMap<>();
//		pathVariables.put("id", "" + workerId);
//		
//		Worker worker = restTemplate.getForObject(wokerHost + "/workers/{id}", Worker.class, pathVariables);
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
//
//	}

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
