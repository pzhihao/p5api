package com.pzhihao.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pzhihao.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	
	/**
	 * employeeService的set方法
	 * @param employeeService
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String list(){
		request.put("employees",employeeService.getAll());
		
		
		return "list";
	}

	/**
	 * 
	 * 获取页面回传的id
	 */
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	
	public String delete(){
		employeeService.delete(id);
		try {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "delete";
	}
	
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
