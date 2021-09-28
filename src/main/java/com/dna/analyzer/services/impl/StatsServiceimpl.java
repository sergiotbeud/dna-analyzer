package com.dna.analyzer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dna.analyzer.model.StatsResponse;
import com.dna.analyzer.repository.DNAAnalyzerRepository;
import com.dna.analyzer.services.StatsService;

@Service
public class StatsServiceimpl implements StatsService{
	
	@Autowired
	DNAAnalyzerRepository dnaAnalyzerRepository;
	
	@Override
	public StatsResponse getStats() {
		
		StatsResponse response= new StatsResponse();
		
		double quantityMutant = dnaAnalyzerRepository.countByType(1);
		double quantityHuman = dnaAnalyzerRepository.countByType(0);
		
		response.setCountMutantDna(quantityMutant);
		response.setCountHumanDna(quantityHuman);
		response.setRatio(getRatio(quantityMutant, quantityHuman));
		
		return response;
	}
	
	private double getRatio(double quantityMutant, double quantityHuman) {
		
		double first = getMin(quantityMutant, quantityHuman);
		double second = (first == quantityMutant)?quantityHuman:quantityMutant;
		
		
		return roundTwoDecimals(first / second);
		
	}

	private double getMin(double quantityMutant, double quantityHuman) {
				
		return (quantityMutant < quantityHuman)
				?quantityMutant
				:quantityHuman;
		
	}
	
	 public static double roundTwoDecimals(double number) {
	        return Math.round(number * 100.0) / 100.0;
	    }

}
