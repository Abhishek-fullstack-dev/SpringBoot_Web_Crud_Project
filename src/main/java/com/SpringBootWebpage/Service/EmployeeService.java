package com.SpringBootWebpage.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootWebpage.Repository.AddressRepository;
import com.SpringBootWebpage.Repository.EmployeeRepository;
import com.SpringBootWebpage.dto.EmployeeDto;
import com.SpringBootWebpage.entity.Address;
import com.SpringBootWebpage.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;   // ✅ renamed for clarity

    @Autowired
    private AddressRepository addressRepo;

    public void saveEmployeeDetails(Employee employee) {
        employeeRepo.save(employee);
    }

    public void saveEmployeeDetailsAndAddress(EmployeeDto employeeDto) {
        // Save Employee
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDto, emp);
        employeeRepo.save(emp);

        // Save Address
        Address addre = new Address();
        BeanUtils.copyProperties(employeeDto, addre);
        addressRepo.save(addre);
    }
    
    public List<Employee> getEmployeeDetail() {
    	return  employeeRepo.findAll();
    	
    }
    public List<Employee> deleteEmployeeDetail(Long id) {
    	  employeeRepo.deleteById(id);
    	  return getEmployeeDetail();
    	
    }
    public void updateEmployeeDetail(EmployeeDto employeeDto) {
    	Employee emp = employeeRepo.findById(employeeDto.getId())
    	        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeDto.getId()));

    	BeanUtils.copyProperties(employeeDto, emp, "id");

        employeeRepo.save(emp);
  	
  }
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(
            () -> new RuntimeException("Employee not found with id: " + id)
        );
    }

}
