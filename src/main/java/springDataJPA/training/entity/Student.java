package springDataJPA.training.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;

@Entity
@NamedEntityGraph(name="StuWithCourse", attributeNodes = {@NamedAttributeNode("course")} )
public class Student{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String name;
	private long fees;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Course> course;
	
	public Student() {
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public List<Course> getCourse() {
		return course;
	}
	
	
	
	public Student(int id, String name, long fees) {
		this.id=id;
		this.fees = fees;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFees() {
		return fees;
	}

	public void setFees(long fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", fees=" + fees + ", course=" + course+"]";
	}
}
