package ec.com.technoloqie.enterprise.ws.apirest.services;

import java.util.List;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Employee;

public interface IEmployeeService {
	
	List<Employee> getListEmployees();
	Employee createEmployee(Employee employee);
	Employee getEmployeeId(Integer code);
    void deleteEmployee(Integer code);
    Employee updateEmployee(Employee employee, int id);

}
