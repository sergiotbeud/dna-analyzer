package com.dna.analyzer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dna.analyzer.model.DNA;
import com.dna.analyzer.repository.DNAAnalyzerRepository;
import com.dna.analyzer.services.DNAAnalyzerService;
import com.dna.analyzer.services.SearchOcurrenceIntoArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class DNAAnalyzerServiceImpl implements DNAAnalyzerService {

	@Autowired
	SearchOcurrenceIntoArray searchOcurrenceIntoArray;

	@Autowired
	DNAAnalyzerRepository dnaAnalyzerRepository;

	Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Override
	public boolean isMutant(DNA dna) {

		String[] mutantSequences = { "AAAA", "TTTT", "CCCC", "GGGG" };
		int timesFound = 0;

		for (String sequence : mutantSequences) {
			timesFound += searchOcurrenceIntoArray.searchOcurrence(dna.getDna(), sequence);
		}

		if (timesFound > 1) {
			dna.setType(1);
			return true;
		} else {
			dna.setType(0);
			return false;
		}
	}

	@Override
	public void saveDNA(DNA dna) {
		if (dnaAnalyzerRepository.findByDna(dna.getDna()) == null) {
			dnaAnalyzerRepository.save(dna);
			logger.info("DNA registrado exitosamente: " + dna);
		} else {
			logger.info("DNA existente: " + dnaAnalyzerRepository.findByDna(dna.getDna()));
		}
	}

	@Override
	public List<DNA> dnaList() {
		return (List<DNA>) dnaAnalyzerRepository.findAll();

	}

}
