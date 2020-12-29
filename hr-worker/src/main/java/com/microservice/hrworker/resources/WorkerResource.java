package com.microservice.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;


@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private WorkerRepository repository;
	
	@Autowired
	private Environment env;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		var workers = repository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findaById(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		var worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
