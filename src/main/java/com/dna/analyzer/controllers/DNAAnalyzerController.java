package com.dna.analyzer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dna.analyzer.model.DNA;
import com.dna.analyzer.services.DNAAnalyzerService;

@RestController
public class DNAAnalyzerController {
	
	@Autowired
	DNAAnalyzerService dnaAnalyzerService;
	
	@PostMapping("/mutant")
	public ResponseEntity<String> dnaAnalyzer(@RequestBody DNA dna) {
		
		ResponseEntity<String> response = dnaAnalyzerService.isMutant(dna)?
				new ResponseEntity<String>("OK", HttpStatus.OK): 
				new ResponseEntity<String>("FORBIDDEN", HttpStatus.FORBIDDEN);
		
		dnaAnalyzerService.saveDNA(dna);
		
		return response;
	}
}
