package com.sarav.practice.service;

import java.sql.SQLException;

import com.sarav.practice.dao.OrderDAO;
import com.sarav.practice.dao.OrderDAOImpl;
import com.sarav.practice.dto.Order;
import com.sarav.practice.exception.BusinessException;

public class OrderServiceImpl implements OrderService {

	
	private OrderDAO orderDao = new OrderDAOImpl();
	
	@Override
	public boolean placeOrder(Order order) throws BusinessException {
		
		try {
			int result = orderDao.create(order);
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		
		return false;
	}

	@Override
	public Order retrieveOrder(int id) throws BusinessException {
		try {
			return orderDao.read(id);
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public boolean cancelOrder(Order order) throws BusinessException {
		try {
			int result = orderDao.update(order);
			if(result > 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		
		return false;
	}

	@Override
	public boolean deleteOrder(int id) throws BusinessException {
		try {
			int result = orderDao.delete(id);
			if(result > 1) {
				return true;
			}
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		
		return false;
	}
    
	@Override
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

}
