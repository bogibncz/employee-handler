package org.company.web.java_web_app;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.apache.log4j.Logger;

@SpringBootApplication
public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner init(EmployeeRepository employeeRepository) {
		return new CommandLineRunner() {
			public void run(String... args) throws Exception {
				Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name-> {
					Employee employee = new Employee(name, name.toLowerCase() + "@domain.com");
					employeeRepository.save(employee);
				});
				employeeRepository.findAll().forEach(System.out::println);
			}
		};
	}

}
