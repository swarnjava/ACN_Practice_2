package com.swarn.employeeDAO;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.swarn.model.EmployeeModel;
import com.swarn.model.EmployeeSalary;

@Service
public class EmployeeSalaryDaoIntrfcImpl implements EmployeeSalaryDaoIntrfc{

	
private final String hashReference= "EmployeeSalary";
	
	@Resource(name="redisTemplate2")          // 'employeeSalaryRedisTemplate' is defined as a Bean in AppConfig.java
   private HashOperations<String, Integer, EmployeeSalary> hashOperations;
	
	@Override
	public void saveEmployeeSalary(EmployeeSalary empSal) {
		// TODO Auto-generated method stub
		hashOperations.putIfAbsent(hashReference, empSal.getEmpId(), empSal);
	}

	@Override
	public EmployeeSalary getEmployeeSalaryByEmployeeId(Integer empId) {
		// TODO Auto-generated method stub
		return hashOperations.get(hashReference, empId);
		//return null;
	}

}
