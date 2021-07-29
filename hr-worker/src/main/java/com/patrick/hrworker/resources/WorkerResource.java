package com.patrick.hrworker.resources;

import java.util.List;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.hrworker.entities.Worker;
import com.patrick.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workersList = workerRepository.findAll();
		return ResponseEntity.ok().body(workersList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		
		  //IMPLEMENTAÇÃO TESTE PARA AVERIGAR O RETORNO DA CHAMADA NO CIRCUIT-BRAKER, NO CASO A CHAMADA DEMORA 15S para retornar
		  
		 
			  try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
		 
		
		logger.info("PORT = " + env.getProperty("local.server.port"));		
		
		Worker worker = workerRepository.findById(id).get();		
		return ResponseEntity.ok().body(worker);
	}

}
