package dao;

import java.util.Collection;

import entities.Employee;

public interface EmployeeDAO {
	public Collection<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	
	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Employee employee);
}
