package springDataJPA.training.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

@Entity
@NamedEntityGraph(name="StuWithCourse", attributeNodes = {@NamedAttributeNode("course")} )
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
