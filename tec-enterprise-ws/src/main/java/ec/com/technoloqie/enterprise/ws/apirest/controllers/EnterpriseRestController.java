package ec.com.technoloqie.enterprise.ws.apirest.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Enterprise;
import ec.com.technoloqie.enterprise.ws.apirest.services.IEnterpriseService;

@CrossOrigin(origins = {"http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api")
public class EnterpriseRestController {
	
	@Autowired
	private IEnterpriseService enterpriseService;
	
	private final Logger log = LoggerFactory.getLogger(EnterpriseRestController.class);

	@GetMapping("/enterprises")
	public List<Enterprise> getListEnterprises() {
		return enterpriseService.getListEnterprises();
	}
	
	
	@GetMapping("/enterprises/{id}")
	public ResponseEntity<?> getEnterpriseId(@PathVariable Integer id) {
		Enterprise enterprise = null;
		Map <String, Object> response = new HashMap<>();
		try {
			enterprise = enterpriseService.getEnterpriseId(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al momento de consultar companias");
			response.put("error", e.getMessage() +" : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(enterprise == null) {
			response.put("mensaje", "La compania id: ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
	}
	
	@PostMapping("/enterprises")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createEnterprise(@Valid @RequestBody Enterprise enterprise, BindingResult result) {
		Enterprise companiaNuevo = null;
		Map <String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo " + err.getField() +" "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			companiaNuevo = enterpriseService.createEnterprises(enterprise);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al momento de crear compani");
			response.put("error", e.getMessage() +" : " + e.getMostSpecificCause());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Compania creada correctamente");
		response.put("compania", companiaNuevo);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/enterprises/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateEnterprises(@RequestBody Enterprise enterprise, @PathVariable Integer id) {
		Enterprise companiaActual = enterpriseService.getEnterpriseId(id);

		Enterprise enterpriseUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if (companiaActual == null) {
			response.put("mensaje", "Error al momento de actualizar compania: ".concat(id.toString()) + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {

			companiaActual.setName(enterprise.getName());
			companiaActual.setAddress(enterprise.getAddress());
			companiaActual.setPhone(enterprise.getPhone());
			companiaActual.setModifiedBy(enterprise.getModifiedBy());
			companiaActual.setModifiedDate(new Date());
			
			
			//clienteActual.setCreateAt(cliente.getCreateAt());

			enterpriseUpdated = enterpriseService.createEnterprises(companiaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al momento de actualizar compania");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Compania actualizado correctamente");
		response.put("compania", enterpriseUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/enterprises/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteEnterprise(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			enterpriseService.deleteEnterprise(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al momento de eliminar compania");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Compania eliminado correctamente");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
