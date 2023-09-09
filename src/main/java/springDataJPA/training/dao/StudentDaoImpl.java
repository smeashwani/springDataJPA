package springDataJPA.training.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springDataJPA.training.entity.Student;

@Repository
public class StudentDaoImpl{

	@Autowired
	private EntityManager em;

	public Student findByEntityGraph(int id){
		EntityGraph<Student> entityGraph = em.createEntityGraph(Student.class);
		entityGraph.addAttributeNodes("course");
		TypedQuery<Student> q = em.createQuery("select s from Student s where id = :id", Student.class)
				.setParameter("id", id)
		        .setHint("javax.persistence.fetchgraph", entityGraph);
		return q.getResultList().get(0);
	}
	
	public Student findBy(int id){
		EntityGraph entityGraph = em.getEntityGraph("StuWithCourse");
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", entityGraph);
		return em.find(Student.class, id, properties);
	}
}
