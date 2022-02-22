package com.swarn.employeeDAO;

import com.swarn.model.EmployeeSalary;

public interface EmployeeSalaryDaoIntrfc {

	public void saveEmployeeSalary(EmployeeSalary empSal);
	public EmployeeSalary getEmployeeSalaryByEmployeeId(Integer empId);
}
