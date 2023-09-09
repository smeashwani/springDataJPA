package springDataJPA.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springDataJPA.training.dao.StudentDaoImpl;
import springDataJPA.training.dao.StudentRepo;
import springDataJPA.training.entity.Student;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepo studentRepo;
	
	@Autowired 
	StudentDaoImpl studentRepoImpl;
	
	public Student save(Student stu){
		return studentRepo.save(stu);
	}

	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
	public Student findByEntityGraph(int id) {
		return studentRepoImpl.findByEntityGraph(id); 
	}
	
	public Student findBy(int id) {
		return studentRepoImpl.findBy(id); 
	}
	
	public List<Student> findByNameLike(String name, Pageable page){
		return studentRepo.findAllByNameLike(name+"%",page);
	}
	
	public Page<Student> findByNameNotLike(String name, Pageable page){
		return studentRepo.findAllByNameNotLike(name+"%",page);
	}
	
	public List<Student> findAllByFeesGreaterThanEqual(long fees, Sort sort) {
		return studentRepo.findAllByFeesGreaterThanEqual(fees,sort);
	}
}
