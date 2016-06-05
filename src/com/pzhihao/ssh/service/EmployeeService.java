package com.pzhihao.ssh.service;

import java.util.List;

import com.pzhihao.ssh.bean.Employee;
import com.pzhihao.ssh.dao.EmployeeDao;

public class EmployeeService {
	private EmployeeDao employeeDao;
	
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/**
	 * 获取所有员工的业务方法
	 * @return
	 */
	public List<Employee> getAll(){
		
		return employeeDao.getAll();
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
}
