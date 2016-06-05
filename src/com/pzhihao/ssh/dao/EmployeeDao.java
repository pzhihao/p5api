package com.pzhihao.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pzhihao.ssh.bean.Employee;

/**
 * 员工的DAO方法
 * @author pzhihao
 *
 */
public class EmployeeDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * 删除员工的方法
	 * @param id
	 */
	public void delete(Integer id){
		String hql="DELETE from Employee e WHERE e.id =?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	/**
	 * 获取所有员工的dao方法
	 * 
	 * @return
	 */
	public List<Employee> getAll(){
		/*左外连接查询*/
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
}
