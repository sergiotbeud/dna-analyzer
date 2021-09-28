package com.dna.analyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dna.analyzer.model.StatsResponse;
import com.dna.analyzer.services.StatsService;

@RestController
public class StatsController {
	
	@Autowired
	StatsService statsService;
	
	
	@GetMapping("/stats")
	public StatsResponse getStats() {
		
		return statsService.getStats();
		
	}
}
