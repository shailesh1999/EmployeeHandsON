package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;

import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;


@SpringBootApplication
public class OrmLearnApplication {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private SkillService skillService;

	private static final Logger logger = LoggerFactory.getLogger(OrmLearnApplication.class);


	
	/*@Bean
	CommandLineRunner testFindEmployee() {
		return args -> {
			logger.info("START... for Employee");
			Employee employee = employeeService.findEmployee(1);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Employee");
		};
	}

	@Bean
	CommandLineRunner testFindDepartment() {
		return args -> {
			logger.info("START... for Department");
			Department department = departmentService.findDepartment(1);
			logger.info("Department Details -> {}", department);
			logger.info("END... for Department");
		};
	}

	@Bean
	CommandLineRunner testFindSkill() {
		return args -> {
			logger.info("START... for Skill");
			Skill skill = skillService.findSkill(2);
			logger.info("Skill Details -> {}", skill);
			logger.info("END... for Skill");
		};
	}

	@Bean
	CommandLineRunner testGetEmployee() {
		return args -> {
			logger.info("START... for Get Employee");
			Employee employee = employeeService.findEmployee(2);
			logger.debug("Employee -> {}", employee);
			logger.debug("Department -> {}", employee.getDepartment());
			logger.debug("Skills -> {}", employee.getSkillList());
			logger.info("END... Get Employee");
		};
	}*/

	@Bean
	CommandLineRunner testAddEmployee() {
		return args -> {
			logger.info("START... for Add Employee");
			Employee.builder().name("Nishanth").salary(500000.00).permanent(true)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01")).build();
			Department department = departmentService.findDepartment(3);
			Employee employee = Employee.builder().name("Nithin").salary(700000.00).permanent(false)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1993-07-02")).department(department).build();
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Add Employee");
		};
	}

	/*@Bean
	CommandLineRunner testUpdateEmployee() {
		return args -> {
			logger.info("START... for Update Employee");
			Employee employee = employeeService.findEmployee(11);
			Department department = departmentService.findDepartment(1);
			employee.setDepartment(department);
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Update Employee");
		};
	}

	@Bean
	CommandLineRunner testDeleteEmployee() {
		return args -> {
			logger.info("START... for Delete Employee");
			employeeService.removeEmployee(11);
			logger.info("END... for Delete Employee");
		};
	}
	
	@Bean
	CommandLineRunner testGetDepartment() {
		return args -> {
			logger.info("START... for Get Department");
			Department department = departmentService.findDepartment(1);
			logger.info("Department -> {}", department);
			logger.info("Employee List -> {}", department.getEmployeeList());
			logger.info("END... for Get Department");
		};
	}
	
	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return args -> {
			logger.info("START... for Add Skill To Employee");
			Employee employee = employeeService.findEmployee(1);
			Skill skill = skillService.findSkill(3);
			employee.getSkillList().add(skill);
			employeeService.saveEmployee(employee);
			logger.info("END... for Add Skill To Employee");
		};
	}

	@Bean
	CommandLineRunner testGetAllPermanentEmployees() {
		return args -> {
			logger.info("START... Permanent Employees");
			List<Employee> employees = employeeService.findAllPermanentEmployees();
			logger.debug("Permanent Employees -> {}", employees);
			employees.forEach(e -> logger.debug("Skills -> {}", e.getSkillList()));
			logger.info("END... Permanent Employees");
		};
	}

	@Bean
	CommandLineRunner testGetAverageSalary() {
		return args -> {
			logger.info("START... Get Average Salary of Employees");
			double salary = employeeService.findAverageSalaryofEmployees();
			logger.info("Average Salary : {}", salary);
			logger.info("END... Get Average Salary of Employees");
		};
	}
	
	@Bean
	CommandLineRunner testGetAverageSalaryBasedOnDeptId() {
		return args -> {
			logger.info("START... Get Average Salary based on Dept id");
			double salary = employeeService.findAverageSalaryBasedOnDeptId(3);
			logger.info("Average Salary : {}", salary);
			logger.info("END... Get Average Salary based on Dept id");
		};
	}

	@Bean
	CommandLineRunner testGetAllEmployeesUsingNativeQuery() {
		return args -> {
			logger.info("START... All Employees Using Native Query");
			employeeService.getAllEmployeesUsingNativeQuery().forEach(e -> logger.info("Employees -> {}", e));
			logger.info("END... All Employees Using Native Query");
		};
	}*/
}