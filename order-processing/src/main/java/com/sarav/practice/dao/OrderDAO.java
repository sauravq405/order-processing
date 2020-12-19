package com.sarav.practice.dao;

import java.sql.SQLException;

import com.sarav.practice.dto.Order;

public interface OrderDAO {
    
	int create(Order order) throws SQLException;
	
	Order read(int id) throws SQLException;
	
	int update(Order order) throws SQLException;
	
	int delete(int id) throws SQLException;
	
}
