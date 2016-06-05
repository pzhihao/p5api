package com.pzhihao.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pzhihao.ssh.bean.Employee;

/**
 * Ա����DAO����
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
	 * ɾ��Ա���ķ���
	 * @param id
	 */
	public void delete(Integer id){
		String hql="DELETE from Employee e WHERE e.id =?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	/**
	 * ��ȡ����Ա����dao����
	 * 
	 * @return
	 */
	public List<Employee> getAll(){
		/*�������Ӳ�ѯ*/
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
}
