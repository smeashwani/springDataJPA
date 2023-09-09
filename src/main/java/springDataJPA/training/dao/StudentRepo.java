package springDataJPA.training.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import springDataJPA.training.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
//	@Override
//	@EntityGraph(attributePaths = {"course"}) 
//	List<Student> findAll();
	
//	@Override
//	@Query("select s from Student s join fetch s.course ")
//	List<Student> findAll();
	
	Optional<Student> findById(Integer id);
	
	List<Student> findAllByNameLike(String name, Pageable page);
	
	Page<Student> findAllByNameNotLike(String name, Pageable page);
	
	List<Student> findAllByFeesGreaterThanEqual(long fees, Sort sort);
}
