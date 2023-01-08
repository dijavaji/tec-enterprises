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

import ec.com.technoloqie.enterprise.ws.apirest.entities.Employee;
import ec.com.technoloqie.enterprise.ws.apirest.services.IEmployeeService;

@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	
	@GetMapping("/employees")
	public List<Employee> getListEmployees() {
		return employeeService.getListEmployees();
	}
	
	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
		Employee empleadoNuevo = null;
		Map <String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() +" "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			empleadoNuevo = employeeService.createEmployee(employee);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al momento de crear empleado");
			response.put("error", e.getMessage() +" : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Empleado creado correctamente");
		response.put("empleado", empleadoNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateEmployees(@RequestBody Employee employee, @PathVariable Integer id) {
		Employee empleadoActual = employeeService.getEmployeeId(id);

		Employee employeeUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if (empleadoActual == null) {
			response.put("mensaje", "Error al momento de actualizar empleado: ".concat(id.toString()) + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			empleadoActual.setName(employee.getName());
			empleadoActual.setAge(employee.getAge());
			empleadoActual.setEmail(employee.getEmail());
			empleadoActual.setPosition(employee.getPosition());
			empleadoActual.setSurname(employee.getSurname());
			empleadoActual.setModifiedBy(employee.getModifiedBy());
			empleadoActual.setModifiedDate(new Date());

			employeeUpdated = employeeService.createEmployee(empleadoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al momento de actualizar empleado");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Empleado actualizado correctamente");
		response.put("empleado", employeeUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
