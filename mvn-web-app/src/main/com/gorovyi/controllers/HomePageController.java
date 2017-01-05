package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDAOImpl;

@Controller
public class HomePageController {
	
	private EmployeeDAOImpl employeeDao = new EmployeeDAOImpl();
	
	@RequestMapping("/")
	public ModelAndView getHomePage(HttpServletRequest request){
		ModelAndView modelView = new ModelAndView("index");
		Map<String, Map<String,String>> testMap = new HashMap<String, Map<String,String>>();
		Map<String, String> linkMap = new HashMap<String,String>();
		
//		System.out.println(employeeDao.getEmployeeById(1).toString());
		
		linkMap.put("jpaLink", request.getRequestURI() + "jpa");
		linkMap.put("hibernateLink", request.getRequestURI() + "hibernate");
		linkMap.put("xmlParsersLink", request.getRequestURI() + "xmlparsers");

		testMap.put("links", linkMap);
		modelView.addAllObjects(testMap);
		return modelView;
	}
}
