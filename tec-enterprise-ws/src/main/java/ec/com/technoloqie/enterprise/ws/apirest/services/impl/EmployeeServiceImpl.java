package ec.com.technoloqie.enterprise.ws.apirest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.technoloqie.enterprise.ws.apirest.dao.IEmployeeDao;
import ec.com.technoloqie.enterprise.ws.apirest.entities.Employee;
import ec.com.technoloqie.enterprise.ws.apirest.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getListEmployees() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee getEmployeeId(Integer code) {
		return employeeDao.findById(code).orElse(null);
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer code) {
		employeeDao.deleteById(code);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
