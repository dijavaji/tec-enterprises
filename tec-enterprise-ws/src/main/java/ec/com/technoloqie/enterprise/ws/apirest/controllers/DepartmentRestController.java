package ec.com.technoloqie.enterprise.ws.apirest.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<?> getDepartmentId(@PathVariable Integer id) {
		Department dept = null;
		Map <String, Object> response = new HashMap<>();
		try {
			dept = departmentService.getDepartmentId(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al momento de consultar departamento");
			response.put("error", e.getMessage() +" : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(dept == null) {
			response.put("mensaje", "El departamento id: ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}
	
	@PostMapping("/departments")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Department dept, BindingResult result) {
		Department deptNuevo = null;
		Map <String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() +" "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			deptNuevo = departmentService.createDepartment(dept);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al momento de crear departamento");
			response.put("error", e.getMessage() +" : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Departamento creado correctamente");
		response.put("departamento", deptNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/departments/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateDepartment(@RequestBody Department dept, @PathVariable Integer id) {
		Department deptActual = departmentService.getDepartmentId(id);

		Department deptUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if (deptActual == null) {
			response.put("mensaje", "Error al momento de actualizar departamento: ".concat(id.toString()) + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			deptActual.setName(dept.getName());
			deptActual.setDescription(dept.getDescription());
			deptActual.setPhone(dept.getPhone());
			deptActual.setModifiedBy(dept.getModifiedBy());
			deptActual.setModifiedDate(new Date());
			deptActual.setEnterprise(dept.getEnterprise());
			
			deptUpdated = departmentService.createDepartment(deptActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al momento de actualizar departamento");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Departamento actualizado correctamente");
		response.put("departamento", deptUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
