package com.dna.analyzer.services;

import org.springframework.stereotype.Service;

import com.dna.analyzer.model.StatsResponse;

@Service
public interface StatsService {
	
	public StatsResponse getStats();

}
