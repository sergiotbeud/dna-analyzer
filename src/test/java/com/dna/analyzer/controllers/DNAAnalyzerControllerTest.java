package com.dna.analyzer.controllers;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dna.analyzer.exceptions.InvalidInputException;
import com.dna.analyzer.exceptions.InvalidSizeException;
import com.dna.analyzer.model.DNA;
import com.dna.analyzer.services.DNAAnalyzerService;
import com.dna.analyzer.services.SearchOcurrenceIntoArray;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class DNAAnalyzerControllerTest {
	
	@Mock
	DNAAnalyzerService dnaAnalyzerService;
	@Mock
	SearchOcurrenceIntoArray searchOcurrenceIntoArray;
	@Autowired
	DNAAnalyzerController controller;
	
	String[] dnaMutant = { "CTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	String[] dnaHuman = { "ATGCCA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	String[] dnaExceptionSize = { "ATGCC", "CAGTG", "TTATG", "AGAAG", "CCCCT", "TCACT" };
	
	@Test
	void testOk() throws InvalidSizeException, InvalidInputException {
		DNA dna = new DNA(dnaMutant);
		dna.setDna(dnaMutant);
		dna.setType(1);
				
		Mockito.when(dnaAnalyzerService.isMutant(dna)).thenReturn(true);
		
		assertEquals(new ResponseEntity<String>("OK", HttpStatus.OK) , controller.dnaAnalyzer(dna));
	}
	
	@Test
	void testForbidden() {
		DNA dna = new DNA();
		dna.setDna(dnaHuman);
		dna.setType(0);
				
		Mockito.when(dnaAnalyzerService.isMutant(dna)).thenReturn(false);
		
		assertEquals(new ResponseEntity<String>("OK", HttpStatus.OK) , controller.dnaAnalyzer(dna));
	}
}
