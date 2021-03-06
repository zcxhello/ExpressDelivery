package org.express.deliver.manager.impl;

import java.util.List;
import java.util.Map;

import org.express.deliver.dao.IOrderDAO;
import org.express.deliver.manager.IOrderManager;
import org.express.deliver.pojo.Order;

public class OrderManagerImpl implements IOrderManager {
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	private IOrderDAO orderDAO;

	@Override
	public Map<String, Object> queryOrderByPaging(int pageNo, int pageSize,
			String keyword) {
		return orderDAO.queryOrderByPaging(pageNo, pageSize, keyword);
	}

	@Override
	public int queryAllOrderAcount() {
		return orderDAO.queryAllOrderAcount();
	}

	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
		
	}

	@Override
	public List<Order> queryOrderLists(String keyword) {
		// TODO Auto-generated method stub
		return orderDAO.queryOrderLists(keyword);
	}

	@Override
	public Order queryOrderById(String id) {
		// TODO Auto-generated method stub
		return orderDAO.queryById(id);
	}

	@Override
	public void modifyOrderInfo(Order order) {
		orderDAO.modifyOrder(order);
		
	}

	@Override
	public List<Order> queryOrdersByTakeUser(String id) {
		// TODO Auto-generated method stub
		return orderDAO.queryOrdersByTakeUser(id);
	}

	@Override
	public List<Order> queryOrdersByProUser(String id) {
		// TODO Auto-generated method stub
		return orderDAO.queryOrdersByProUser(id);
	}

	@Override
	public void delOrder(Order order) {
		orderDAO.delOrder(order);
	}

}
