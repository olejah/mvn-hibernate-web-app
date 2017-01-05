package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {
	
	private static final long serialVersionUID = 7842358842316065916L;

	@Id
	@Column(name="p_id")
	private int id;
	
	@Column(name="p_name")
	private String name;
	
	public Project() {}
	
	public Project(int id, String name) {
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
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Project other = (Project) o;
		
		if (id != other.id) return false;
		if (!name.equals(other.name)) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
	
	@Override
	public String toString() {
		return "Project -> id = " + id + ", name = " + name;
	}
}
