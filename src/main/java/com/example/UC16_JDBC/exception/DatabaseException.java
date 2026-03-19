package com.example.UC16_JDBC.exception;

public class DatabaseException extends RuntimeException {

	public DatabaseException(String message,Throwable cause) {
		super(message,cause);
	}
}
