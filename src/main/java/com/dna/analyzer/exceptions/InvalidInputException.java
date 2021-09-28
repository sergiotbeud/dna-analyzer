package com.dna.analyzer.exceptions;

public class InvalidInputException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
        super("El ADN contiene valores inválidos");
    }
}
