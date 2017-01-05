package dao;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Employee;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
	private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("employee");
	private EntityManager entityManager;
	
	public EmployeeDAOImpl(){
		
	}
	
	public List<Employee> getAllEmployees(){
		entityManager = FACTORY.createEntityManager();
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
		List<Employee> employeeList = query.getResultList();
		entityManager.close();
		return employeeList;
	}
	
	public Employee getEmployeeById(int id){
		entityManager = FACTORY.createEntityManager();
		Employee employee = null;
		System.out.println(entityManager.toString());
		entityManager.getTransaction().begin();
		employee  = entityManager.find(Employee.class, id);
		entityManager.getTransaction().commit();
		System.out.println(entityManager.toString());
		System.out.println(entityManager.getTransaction().isActive());
		entityManager.close();
		return employee;
	}
	
	public void addEmployee(Employee employee){
		entityManager = FACTORY.createEntityManager();
		System.out.println("entityManager : " + entityManager);
		System.out.println("transaction : " + entityManager.getTransaction().toString());
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteEmployee(Employee employeeId) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(int employeeId, double salary) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	
}
