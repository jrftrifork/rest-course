package com.trifork.hr.persistence;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Long id) {
		super(id.toString());
	}
}
