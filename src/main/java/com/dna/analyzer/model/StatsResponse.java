package com.dna.analyzer.model;

public class StatsResponse {
	
	private double countMutantDna;
	private double countHumanDna;
	private double ratio;
	
	public StatsResponse(double countMutantDna, double countHumanDna, double ratio) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}

	public StatsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(double countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public double getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(double countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}
