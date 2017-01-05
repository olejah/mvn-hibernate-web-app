package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDAOImpl;
import entities.Employee;

@Controller
public class JpaPageController {
//	private EmployeeDAO employeeDao = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAOImpl employeeDao;
	
	@RequestMapping("/jpa")
	public ModelAndView getJpaPage(){
		ModelAndView modelView = new ModelAndView("jpa");
		modelView.addObject("employeeList", employeeDao.getAllEmployees());
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\" : \"JsonName\", \"salary\" : \"100.1\", \"deg\" : \"Position\"}";
		try {
			Employee employee = mapper.readValue(jsonString, Employee.class);
			System.out.println(employee.toString());
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
		return modelView;
	}
	
	@RequestMapping(value = "/jpa-add-employee", method = RequestMethod.POST)
	public @ResponseBody String addEmployee(HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(request.getParameterMap().keySet().iterator().next().toString(), Employee.class);
			System.out.println(employee.toString());
			employeeDao.addEmployee(employee);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
