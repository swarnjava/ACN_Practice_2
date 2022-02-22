package com.swarn.employeeDAO;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.swarn.model.EmployeeModel;

@Service
public class EmployeeDaoIntrfcImpl implements EmployeeDaoIntrfc{
	
	private final String hashReference= "Employee";
	
	@Resource(name="redisTemplate")          // 'employeeRedisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, EmployeeModel> hashOperations;

	@Override
	public void saveEmployee(EmployeeModel emp) {
		// TODO Auto-generated method stub
		//creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public EmployeeModel getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return hashOperations.get(hashReference, id);
		
	}

	@Override
	public void updateEmployee(EmployeeModel emp) {
		// TODO Auto-generated method stub
		hashOperations.put(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Map<Integer, EmployeeModel> getAllEmployees() {
		// TODO Auto-generated method stub
		return hashOperations.entries(hashReference);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		hashOperations.delete(hashReference, id);
	}

	@Override
	public void saveAllEmployees(Map<Integer, EmployeeModel> map) {
		// TODO Auto-generated method stub
		
	}

}
