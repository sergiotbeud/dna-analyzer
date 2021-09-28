package com.dna.analyzer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.dna.analyzer.exceptions.InvalidInputException;
import com.dna.analyzer.exceptions.InvalidSizeException;
import com.sun.istack.NotNull;

@Entity
public class DNA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String[] dna;

	@NotNull
	private int type;

	@Transient
	private String dnaLetterRegex = "[ACGT]+";

	public DNA(String[] dna) throws InvalidSizeException, InvalidInputException {
		validations(dna);

		this.dna = dna;
	}

	public DNA() {
		super();
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < dna.length; i++) {
			result += dna[i] + "-";
		}
		return result.substring(0, result.length() - 1);
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private void validations(String[] dna) throws InvalidSizeException, InvalidInputException {

		ifNullOrEmpty(dna);
		ifCorrectSize(dna);
		validateInputDna(dna);
	}

	private void ifNullOrEmpty(String[] dna) throws InvalidSizeException {
		if (dna == null || dna.length == 0 || dna.length != dna[0].length()) {
			throw new InvalidSizeException();
		}
	}

	private void ifCorrectSize(String[] dna) throws InvalidSizeException {
		for (int i = 1; i < dna.length; i++) {
			if (dna[i].length() != dna[0].length())
				throw new InvalidSizeException();
		}
	}

	private void validateInputDna(String[] dna) throws InvalidInputException {
		for (int i = 0; i < dna.length; i++) {
			if (!dna[i].matches(dnaLetterRegex))
				throw new InvalidInputException();
		}
	}
}
