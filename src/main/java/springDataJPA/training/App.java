package springDataJPA.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		System.out.println("FIND ALL ------------------");
		System.out.println(stuService.findBy(1));
		System.out.println(stuService.findByEntityGraph(1));
	}	
}
