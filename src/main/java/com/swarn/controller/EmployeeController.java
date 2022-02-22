package com.swarn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swarn.employeeDAO.EmployeeDaoIntrfc;
import com.swarn.employeeDAO.EmployeeSalaryDaoIntrfc;
import com.swarn.model.EmployeeModel;
import com.swarn.model.EmployeeSalary;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDaoIntrfc empDao;

	@Autowired
	private EmployeeSalaryDaoIntrfc empSalaryDao;

	@GetMapping(value = "/create/{empId}/{empAddress}/{empContactNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createSingleEmployee(@PathVariable("empId") Integer empId,
			@PathVariable("empAddress") String empAddress, @PathVariable("empContactNo") String empContactNo) {
		EmployeeModel em = new EmployeeModel();
		em.setEmpId(empId);
		em.setEmpAddress(empAddress);
		em.setEmpContactNo(empContactNo);
		empDao.saveEmployee(em);

		return new ResponseEntity<>("Data Saved Successfully", null, HttpStatus.OK);

	}

	@GetMapping(value = "/fetchEmployee/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeModel> getSingleEmployee(@PathVariable("empId") Integer empId) {

		return new ResponseEntity<>(empDao.getOneEmployee(empId), null, HttpStatus.OK);

	}

	@GetMapping(value = "/createSalary/{empId}/{empSal}/{empDesig}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createSingleEmployeeSalary(@PathVariable("empId") Integer empId,
			@PathVariable("empSal") Double empSal, @PathVariable("empDesig") String empDesig) {

		EmployeeSalary es = new EmployeeSalary();
		es.setEmpId(empId);
		es.setEmpSal(empSal);
		es.setEmpDesig(empDesig);
		empSalaryDao.saveEmployeeSalary(es);

		return new ResponseEntity<>("Data Saved Successfully", null, HttpStatus.OK);

	}

	@GetMapping(value = "/fetchEmployeeSalary/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeSalary> getSingleEmployeeSalary(@PathVariable("empId") Integer empId) {

		return new ResponseEntity<>(empSalaryDao.getEmployeeSalaryByEmployeeId(empId), null, HttpStatus.OK);

	}

}
