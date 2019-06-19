package org.company.web.java_web_app;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	private final EmployeeRepository employeeRepository;	

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping("/add-employee")
    public void addUser(@RequestBody Employee employee) {
    	employeeRepository.save(employee);
    }
    
    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
    	employeeRepository.deleteById(Long.valueOf(id));
    }
}
