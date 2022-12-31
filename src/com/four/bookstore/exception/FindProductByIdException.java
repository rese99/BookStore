package com.four.bookstore.exception;

public class FindProductByIdException extends Exception {

	public FindProductByIdException() {
		super();
	}

	public FindProductByIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public FindProductByIdException(String message) {
		super(message);
	}

	public FindProductByIdException(Throwable cause) {
		super(cause);
	}

}
