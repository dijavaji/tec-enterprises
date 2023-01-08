package ec.com.technoloqie.enterprise.ws.apirest.services;

import java.util.List;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Department;

public interface IDepartmentService {
	
	List<Department> getListDepartment();
	Department createDepartment(Department department);
	Department getDepartmentId(Integer code);
    void deleteDepartment(Integer code);
    Department updateDepartment(Department department, int id);

}
