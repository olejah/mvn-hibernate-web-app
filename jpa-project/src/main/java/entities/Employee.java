package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1542356789L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private double salary;
	private String deg;
	private Department department;
	private Set<Project> projectSet;
	
	public Employee(){
		
	}
	
	public Employee(int id, String name, double salary, String deg){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deg = deg;
	}
	
	public Employee(int id, String name, double salary, String deg, Department department){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deg = deg;
	}
	
	public Employee(String name, double salary, String deg){
		this.name = name;
		this.salary = salary;
		this.deg = deg;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public String getDeg(){
		return this.deg;
	}
	
	public void setDeg(String deg){
		this.deg = deg;
	}
	
	public Department getDepartment() {
		return this.department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Set<Project> getProjectSet() {
		return this.projectSet;
	}
	
	public void setProjectSet(Set<Project> projectSet){
		this.projectSet = projectSet;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (salary != employee.salary) return false;
        if (deg != null ? !deg.equals(employee.deg) : employee.deg == null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department == null) return false;
        
        return (projectSet != null ? !projectSet.equals(employee.projectSet) : employee.department == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = (int) (31 * result + salary);
        result = 31 * result + (deg != null ? deg.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (projectSet != null ? projectSet.hashCode() : 0);
        return result;
    }
    
    @Override
	public String toString(){
		final StringBuilder sb = new StringBuilder("Employee [id=").append(id).append("', name='").append(name)
								.append("', salary=").append(salary).append("', deg='").append(deg).append("', department='").append(department).append(", projects=[").append(projectSet).append("']");
		
		return sb.toString();
	}
	
}
