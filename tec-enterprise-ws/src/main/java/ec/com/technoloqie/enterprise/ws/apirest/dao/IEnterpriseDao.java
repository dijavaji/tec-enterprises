package ec.com.technoloqie.enterprise.ws.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Enterprise;

public interface IEnterpriseDao extends JpaRepository<Enterprise, Integer>{

}
