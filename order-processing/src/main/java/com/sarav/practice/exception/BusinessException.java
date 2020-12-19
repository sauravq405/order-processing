package com.sarav.practice.exception;

import java.sql.SQLException;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(SQLException e) {
		super(e);
	}

}
