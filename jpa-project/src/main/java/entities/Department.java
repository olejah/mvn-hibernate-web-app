package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department implements Serializable {
	
	private static final long serialVersionUID = 134556635352L;

	@Id
	private int id;
	
	private String name;
	
	public Department() {}
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Department other = (Department) o;
		
		if (id != other.id) return false;
		if (!name.equals(other.name)) return false;
		
		return true;
	}
	
	@Override
	public String toString(){
		return "Department -> id = " + id + ", name = " + name;
	}
}
