package ec.com.technoloqie.enterprise.ws.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Department;
import ec.com.technoloqie.enterprise.ws.apirest.services.IDepartmentService;

@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api")
public class DepartmentRestController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getListDepartments() {
		return departmentService.getListDepartment();
	}

}
