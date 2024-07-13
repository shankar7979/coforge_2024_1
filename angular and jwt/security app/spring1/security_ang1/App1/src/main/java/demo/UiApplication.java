package demo;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin("http://localhost:4200")
public class UiApplication {

	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	@GetMapping("/all")
	public List<Employee> allEmployee(){
		return Arrays.asList(
				new Employee[]{
						new Employee(10001,"ram"),
						new Employee(10001,"ram"),
						new Employee(10001,"ram"),
						new Employee(10001,"ram"),
						new Employee(10001,"ram")
				}
		);
	}
	@Data
	@AllArgsConstructor
	class Employee{
		private int id;
		private String name;
	}

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
//https://spring.io/guides/tutorials/spring-security-and-angular-js
//https://github.com/spring-guides/tut-spring-security-and-angular-js/blob/main/basic/src/app/app.component.html
