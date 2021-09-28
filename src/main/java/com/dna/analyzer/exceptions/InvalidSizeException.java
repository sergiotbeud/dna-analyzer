package com.dna.analyzer.exceptions;

public class InvalidSizeException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidSizeException() {
	        super("Longitud inválida, debe ser de N X N");
	    }

}
