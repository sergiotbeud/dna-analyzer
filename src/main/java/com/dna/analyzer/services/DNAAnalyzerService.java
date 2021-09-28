package com.dna.analyzer.services;

import java.util.List;

import com.dna.analyzer.model.DNA;

public interface DNAAnalyzerService {
		
		public boolean isMutant(DNA dna);
		
		public void saveDNA(DNA dna);
		
		public List<DNA> dnaList();

	}


