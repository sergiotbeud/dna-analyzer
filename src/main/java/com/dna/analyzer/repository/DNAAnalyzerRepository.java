package com.dna.analyzer.repository;

import org.springframework.data.repository.CrudRepository;

import com.dna.analyzer.model.DNA;

public interface DNAAnalyzerRepository extends CrudRepository<DNA, Long>{
	
	public DNA findByDna(String[] dna);
	public Double countByType(int type);

}
