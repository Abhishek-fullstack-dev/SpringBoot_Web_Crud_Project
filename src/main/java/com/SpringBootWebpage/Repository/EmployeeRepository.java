package com.SpringBootWebpage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootWebpage.entity.Employee;

public interface  EmployeeRepository extends JpaRepository<Employee, Long> {

}
