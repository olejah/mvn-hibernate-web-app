package controllers;

import java.io.IOException;
import java.util.LinkedHashSet;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.HibernateEmployeeDAOImpl;
import entities.Employee;

@Controller
public class HibernatePageController {
	
	@Autowired
	private HibernateEmployeeDAOImpl dao;
	
	@RequestMapping("/hibernate")
	public ModelAndView getHibernatePage(){
		return new ModelAndView("hibernate");
	}
	
	@RequestMapping(value = "/hibernate-get-employee-list")
	public @ResponseBody String getEmployeeList(){
		String msg = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			LinkedHashSet<Employee> employeeCollection = dao.getAllEmployees();
			msg = mapper.writeValueAsString(employeeCollection);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@RequestMapping(value = "/hibernate-add-employee", method = RequestMethod.POST)
	public @ResponseBody String addEmployee(HttpServletRequest request){
		String msg = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(request.getParameterMap().keySet().iterator().next().toString(), Employee.class);
			dao.addEmployee(employee);
			msg = "OK";
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	
	@RequestMapping(value = "/hibernate-delete-employee", method = RequestMethod.DELETE)
	public @ResponseBody String deleteEmployee(@RequestBody String employeeJson){
		System.out.println(employeeJson);
		
		String msg = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(employeeJson.toString(), Employee.class);
			dao.deleteEmployee(employee);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value = "/hibernate-edit-employee", method = RequestMethod.PUT)
	public @ResponseBody String updateEmployee(@RequestBody String employeeJson){
		String msg = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(employeeJson.toString(), Employee.class);
			dao.updateEmployee(employee);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
