package com.example.project2.controller;
import java.util.Map;
import java.util.Optional;
//import org.apache.el.stream.Optional;
import com.example.project2.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.repository.EmployeeRepo;
import com.example.project2.repository.EmployeeRepository2;

@RestController
public class MainController {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
    private EmployeeRepository2 employeeRepository2;
	
	@PostMapping("/addEmployee")
	public String addStudent(@RequestBody Employee employee) {
		employeeRepo.save(employee);	
		return "Successfully Created";
	}
	 @PostMapping("/addEmployee2")
	    public String addEmployee2(@RequestBody Employee employee) {
	        // Save to database2
	        employeeRepository2.save(employee);
	        return "Successfully Created";
	    }
	
	 @DeleteMapping("/deleteEmployee/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
	        try {
	            employeeRepo.deleteById(id);
	            return new ResponseEntity<>("Employee successfully deleted", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to delete employee", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	 @PutMapping("/updateEmployee")
	 public ResponseEntity<String> updateEmployee(@RequestBody Map<String, String> requestBody) {
	     String id = requestBody.get("id");
	     if (id == null) {
	         return new ResponseEntity<>("ID is missing in the request body", HttpStatus.BAD_REQUEST);
	     }
	     
	     Optional<Employee> optionalEmployee = employeeRepo.findById(id);
	     if (optionalEmployee.isPresent()) {
	         Employee updatedEmployee = optionalEmployee.get();
	         updatedEmployee.setId(id); 
	         
	         
	         String phnoString = requestBody.get("phno");
	         if (phnoString != null && !phnoString.isEmpty()) {
	             try {
	                 int phno = Integer.parseInt(phnoString);
	                 updatedEmployee.setPhno(phno);
	             } catch (NumberFormatException e) {
	                 return new ResponseEntity<>("Invalid phone number format", HttpStatus.BAD_REQUEST);
	             }
	         } else {
	             return new ResponseEntity<>("Phone number is missing in the request body", HttpStatus.BAD_REQUEST);
	         }
	         
	         updatedEmployee.setEmpAddress(requestBody.get("empAddress"));
	         employeeRepo.save(updatedEmployee);
	         return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	     }
	 }

    
	        
	        @GetMapping("/getEmployee/{id}")
	        public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
	            Employee employee = employeeRepo.findById(id).orElse(null);
	            if (employee != null) {
	                return new ResponseEntity<>(employee, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        }
	        
	        @GetMapping("/getAllEmployees")
	        public ResponseEntity<Iterable<Employee>> getAllEmployees() {
	            Iterable<Employee> employees = employeeRepo.findAll();
	            return new ResponseEntity<>(employees, HttpStatus.OK);
	        }
	        
	        
	        @PostMapping("/addMultipleEmployees")
	        public ResponseEntity<String> addMultipleEmployees(@RequestBody Employee[] employees) {
	            for (Employee employee : employees) {
	            	employeeRepo.save(employee); 
	                System.out.println("Saved employee: " + employee);
	            }
	            return new ResponseEntity<>("Multiple employees added successfully", HttpStatus.OK);
	        }
}





//package com.example.project2.controller;
//
//import com.example.project2.model.Employee;
//import com.example.project2.repository.EmployeeRepo;
//import com.example.project2.repository.EmployeeRepository2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MainController {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Autowired
//    private EmployeeRepository2 employeeRepository2;
//
//    @PostMapping("/addEmployee")
//    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
//        employeeRepo.save(employee);
//        return new ResponseEntity<>("Employee saved to default database", HttpStatus.OK);
//    }
//
//    @PostMapping("/addEmployee2")
//    public ResponseEntity<String> addEmployee2(@RequestBody Employee employee) {
//        employeeRepository2.save(employee);
//        return new ResponseEntity<>("Employee saved to secondary database", HttpStatus.OK);
//    }
//}
//
