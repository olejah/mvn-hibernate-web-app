package dao;

import java.util.LinkedHashSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Employee;

@Transactional
@Service(value="dao")
public class HibernateEmployeeDAOImpl implements EmployeeDAO {
	private final static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public HibernateEmployeeDAOImpl() {}
	
	public LinkedHashSet<Employee> getAllEmployees() {
		Session session = factory.openSession();
		Transaction transaction = null;
		LinkedHashSet<Employee> employeeCollection = null;
		
		try {
			transaction = session.beginTransaction();
			employeeCollection = new LinkedHashSet<Employee>(session.createQuery("FROM Employee emp left join fetch emp.projectSet left join fetch emp.department order by emp.id").list());
			transaction.commit();
		} catch(HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return employeeCollection;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEmployee(Employee employee) {
		System.out.println(employee);
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch(HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deleteEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(employee);
			session.flush();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void updateEmployee(Employee newEmployee) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee dbEmployee = 
	                    (Employee)session.get(Employee.class, newEmployee.getId());
	         dbEmployee.setName(newEmployee.getName());
	         dbEmployee.setSalary(newEmployee.getSalary());
	         dbEmployee.setDeg(newEmployee.getDeg());
			 session.update(dbEmployee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) {
	        	 tx.rollback();
	         }
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}

}

