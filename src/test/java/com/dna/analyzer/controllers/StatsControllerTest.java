package com.dna.analyzer.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dna.analyzer.model.StatsResponse;
import com.dna.analyzer.services.StatsService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class StatsControllerTest {

	@Mock
	StatsService statsService;

	@Autowired
	StatsController statsController;

	@Test
	void testOk() {
		
		StatsResponse response = new StatsResponse(40, 100, 0.4);

		assertNotNull(statsController.getStats());
	}

}
