package com.SpringBootWebpage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBootWebpage.Service.EmailService;
import com.SpringBootWebpage.Service.EmployeeService;
import com.SpringBootWebpage.entity.Employee;
import com.SpringBootWebpage.dto.EmployeeDto;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; 
    
    // ✅ spelling fixed
    
    @Autowired
    private EmailService emailService;

    // Show registration page
    @GetMapping("/view")
    public String viewReg() {
        return "Register";   // Make sure you have Register.jsp under /WEB-INF/views/ (or as per your config)
    }

    // Save only Employee (no address)
    @PostMapping("/saveReg")
    public String saveRegistration(@ModelAttribute Employee employee, Model model) {

    	employeeService.saveEmployeeDetails(employee);

        model.addAttribute("msg", "Employee has successfully registered");
        return "Register";
    }

    // Save Employee + Address using DTO
    @PostMapping("/saveRegistration")
    public String getRegistrationDetails(@ModelAttribute EmployeeDto employeeDto, Model model) {

        employeeService.saveEmployeeDetailsAndAddress(employeeDto);
        // ✅ use injected bean, not class name
        
        
        emailService.SendEmail(employeeDto.getEmail(), "Welcome to", "This is a Test");

        model.addAttribute("msg", "Record is saved");
        return "Register";   // ✅ keep same view name as /view
    }
    @GetMapping("/viewEmployee")
    public String viewEmployee(ModelMap model) {

        List<Employee> employees = employeeService.getEmployeeDetail();

        System.out.println("DEBUG size = " + employees.size()); // just to check in console

        model.addAttribute("employees", employees);  // ✅ KEY NAME: "employees"

        return "List";  // List.jsp
    }
    @GetMapping("/MenuPage")
    public String MenuPage() {
        return "Menu";   // Make sure you have Register.jsp under /WEB-INF/views/ (or as per your config)
    }
    
    @RequestMapping("/deleteRegistration")
    public String deleteRegistration(@RequestParam Long id ,ModelMap model ) {
    	List<Employee> employees=employeeService.deleteEmployeeDetail(id);
    	model.addAttribute("employees", employees);
    	return"List";
    	
    }
    @RequestMapping("/updateRegistration")
    public String updateRegistration(@ModelAttribute EmployeeDto employeeDto, Model model ) {
    	employeeService.updateEmployeeDetail(employeeDto);
    	
    	List<Employee> employees = employeeService.getEmployeeDetail();

        System.out.println("DEBUG size = " + employees.size()); // just to check in console

        model.addAttribute("employees", employees);  // ✅ KEY NAME: "employees"

        return "List";
    	
    }
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);   // this is used in UpdatePage.jsp

        return "Update";   // name of your update JSP
    }

}
