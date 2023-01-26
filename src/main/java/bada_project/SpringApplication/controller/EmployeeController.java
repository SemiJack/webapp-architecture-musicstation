package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.AddressDAO;
import bada_project.SpringApplication.dao.EmployeeDAO;
import bada_project.SpringApplication.dao.JobpositionDAO;
import bada_project.SpringApplication.model.Address;
import bada_project.SpringApplication.model.Employee;
import bada_project.SpringApplication.model.Jobposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private JobpositionDAO jobpositionDAO;

    @RequestMapping(value = {"/employees/add/save","/employees/update/save"},method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeDAO.saveOrUpdate(employee);
        return "redirect:/employees/show";
    }

    @RequestMapping("/employees/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        employee.setNr_rozglosni(1);
        List<Address> addresses= addressDAO.getAll();
        List<Jobposition> jobpositions = jobpositionDAO.getAll();
        model.addAttribute("jobposinions", jobpositions);
        model.addAttribute("addresses", addresses);
        model.addAttribute("employee", employee);
        return "employees/add-employees";
    }


    @RequestMapping("/employees/show")
    public String viewTableEmployees(Model model) {
        List<Employee> employees = employeeDAO.getAll();
        model.addAttribute("employees", employees);
        return "employees/show-employees";
    }

    @RequestMapping("/employees/delete")
    public String viewDeleteTableEmployees(Model model) {
        List<Employee> employees = employeeDAO.getAll();
        model.addAttribute("employees", employees);
        return "employees/delete-employees";
    }

    @RequestMapping(value="/employees/show/{user}")
    public ModelAndView viewEmployee(@PathVariable(name = "user")String user) {
        ModelAndView mav = new ModelAndView("/employees/show-employee");
        List<Employee> employee = new ArrayList<>();
        employee.add(employeeDAO.getByName(user));
        mav.addObject("employees", employee);
        return mav;
    }

    @RequestMapping(value="/employees/update/{id}")
    public ModelAndView updateEmployee(@PathVariable(name = "id")int id) {
        ModelAndView mav = new ModelAndView("/employees/update-employees");
        Employee employee = employeeDAO.get(id);

        mav.addObject("employees",employee);
        return mav;
    }

    @RequestMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id")int id) {
        employeeDAO.delete(id);
        return "redirect:/employees/delete";
    }
}

