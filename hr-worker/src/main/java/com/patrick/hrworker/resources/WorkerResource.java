package com.patrick.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workersList = workerRepository.findAll();
		return ResponseEntity.ok().body(workersList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) {
		Optional<Worker> worker = workerRepository.findById(id);		
		return ResponseEntity.ok().body(worker);
	}

}
