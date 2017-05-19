package org.express.deliver.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.express.deliver.dao.IUserDAO;
import org.express.deliver.pojo.User;
import org.hibernate.Query;

/**
 * 用户DAO操作接口实现类
 * 
 * @author 吴文鑫
 * 
 */
public class UserDAOImpl extends BaseDAO implements IUserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {
		String hql = "FROM User AS u WHERE u.userName=? AND u.password=? AND u.userType=? AND u.expressType = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		query.setString(2, user.getUserType());
		query.setString(3, user.getExpressType());
		List<User> lUsers = query.list();
		if (lUsers != null && lUsers.size() > 0) {
			return lUsers.get(0);
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public void delUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void modifyUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Override
	public Map<String, Object> queryUserByPaging(int pageNo, int pageSize,
			String keyword, String userType, String expressType) {
		String hql = "FROM User AS u WHERE u.userType=? AND u.expressType=? AND u.userName LIKE ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userType);
		 query.setString(1, expressType);
		 query.setString(2, "%" + keyword + "%");
		// query.setString(3, "%" + keyword + "%");
		int count=query.list().size();
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("count", count);
		map.put("users", query.list());
		map.put("userType", userType);
		map.put("expressType", expressType);
		return map;
	}

	@Override
	public List<String> queryAllUserName() {
		String hql = "SELECT u.userName FROM User AS u";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<String> allUserNames = query.list();
		return allUserNames;
	}

	@Override
	public int queryAllUserAcount() {
		String hql = "SELECT COUNT(u) FROM User AS u";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public void modifyUserPassword(User user) {
		String hql = " UPDATE User AS u SET u.password=? WHERE u.telephone=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getPassword());
		query.setString(1, user.getTelephone());
		query.executeUpdate();
	}

	@Override
	public List<String> queryAllUserTelephone() {
		String hql = "SELECT u.telephone FROM User AS u";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<String> allUsertelephone = query.list();
		return allUsertelephone;
	}

}
