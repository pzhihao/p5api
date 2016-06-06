package com.pzhihao.ssh.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensymphony.xwork2.ActionSupport;
import com.pzhihao.ssh.bean.Employee;
import com.pzhihao.ssh.service.EmployeeService;

import net.sf.json.JSONObject;


/**
@author  作者 E-mail:  
@date 创建时间：2016年6月6日 下午2:13:47
@version 1.0 
@parameter  
@since 
@return  
*/
public class EmployeeApiAction extends ActionSupport{
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	private Map<String ,Object> result;
	
	
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public Object getall(){
		List<Employee> employee=employeeService.getAll();
		
		
		Map<String ,Object> map=new HashMap<>();
		
		Map<String,Object> data=new HashMap<String, Object>();
		
		map.put("employee",employee);
		data.put("data",map);
		
		result=data;
		
		
		return SUCCESS;
	}

	

	
	
}
