package ec.com.technoloqie.enterprise.ws.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Department;

public interface IDepartmentDao extends JpaRepository<Department, Integer>{

}
