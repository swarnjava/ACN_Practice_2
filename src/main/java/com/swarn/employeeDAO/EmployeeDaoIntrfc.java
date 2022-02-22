package com.swarn.employeeDAO;

import java.util.Map;

import com.swarn.model.EmployeeModel;

public interface EmployeeDaoIntrfc {
	
public void saveEmployee(EmployeeModel emp);
EmployeeModel getOneEmployee(Integer id);

void updateEmployee(EmployeeModel emp);
Map<Integer, EmployeeModel> getAllEmployees();
void deleteEmployee(Integer id);
void saveAllEmployees(Map<Integer, EmployeeModel> map);
}
