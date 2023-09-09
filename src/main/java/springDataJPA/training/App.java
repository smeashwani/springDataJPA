package springDataJPA.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import springDataJPA.training.config.AppConfig;
import springDataJPA.training.entity.Course;
import springDataJPA.training.entity.Student;
import springDataJPA.training.service.StudentService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService stuService = ctx.getBean(StudentService.class);
		Student s = new Student();
		s.setName("guest");
		s.setFees(10_000);
		s.setCourse(List.of(new Course("guest_course1","12_hrs"),new Course("guest_course2","12_hrs")));
		s = stuService.save(s);
		
		System.out.println("SAVED: - "+s);
		
		s = new Student();
		s.setName("Guest_11");
		s.setFees(11_000);
		s.setCourse(List.of(new Course("guest11_course1","12_hrs"),new Course("guest11_course2","12_hrs")));
		s = stuService.save(s);
		
		System.out.println("SAVED: - "+s);
		
		s = new Student();
		s.setName("Guest_22");
		s.setFees(22_000);
		s.setCourse(List.of(new Course("guest11_course1","12_hrs"),new Course("guest11_course2","12_hrs")));
		s = stuService.save(s);
		
		System.out.println("SAVED: - "+s);
		System.out.println("FIND By ID ------------------");
		System.out.println(stuService.findBy(1));
		System.out.println("FIND ALL ------------------");
		System.out.println(stuService.findAll());
		
		// first page contains only 3 elements
		System.out.println("Find by name like ------------------");
		Pageable firstPageWith3Elements = PageRequest.of(0, 2);
		System.out.println("Find by name like: \n"+ stuService.findByNameLike("Guest",firstPageWith3Elements));

		System.out.println("Find by name not like ------------------");
		Page<Student> page = stuService.findByNameNotLike("Best",firstPageWith3Elements);
		System.out.println("Find by name not like: \n"+ page.getContent());
		System.out.println("Find by name not like getTotalPages: "+ page.getTotalPages());
		System.out.println("Find by name not like getTotalElements: "+ page.getTotalElements());

		System.out.println("Find all stu by fees ascending: \n"+ stuService.findAllByFeesGreaterThanEqual(10000, Sort.by("fees"))); // default order ascending
		System.out.println("Find all stu by fees descending: \n"+ stuService.findAllByFeesGreaterThanEqual(10000, Sort.by("fees").descending()));

		//System.out.println(stuService.findByEntityGraph(1));
	}
}
