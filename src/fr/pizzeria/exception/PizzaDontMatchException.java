package fr.pizzeria.exception;

public class PizzaDontMatchException extends Exception {
	public PizzaDontMatchException() {
		
	}
	
	public PizzaDontMatchException(String msg) {
		super(msg);
		
	}
}
