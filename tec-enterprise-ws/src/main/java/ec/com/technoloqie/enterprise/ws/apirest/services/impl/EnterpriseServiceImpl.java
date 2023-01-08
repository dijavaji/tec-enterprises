package ec.com.technoloqie.enterprise.ws.apirest.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.technoloqie.enterprise.ws.apirest.dao.IEnterpriseDao;
import ec.com.technoloqie.enterprise.ws.apirest.entities.Enterprise;
import ec.com.technoloqie.enterprise.ws.apirest.services.IEnterpriseService;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService{
	
	@Autowired
	private IEnterpriseDao enterpriseDao;

	@Override
	@Transactional(readOnly = true)
	public List<Enterprise> getListEnterprises() {
		return (List<Enterprise>) enterpriseDao.findAll();
	}

	@Override
	@Transactional
	public Enterprise createEnterprises(Enterprise enterprise) {
		return enterpriseDao.save(enterprise);
	}

	@Override
	@Transactional(readOnly = true)
	public Enterprise getEnterpriseId(Integer code) {
		return enterpriseDao.findById(code).orElse(null);
	}

	@Override
	@Transactional
	public void deleteEnterprise(Integer code) {
		enterpriseDao.deleteById(code);
	}

	@Override
	@Transactional
	public Enterprise updateEnterprise(Enterprise enterprise, int id) {
		Enterprise existeCompania = getEnterpriseId(id); //tenemos que comprobar si con la identificación dada existe en la db o no
		existeCompania.setName(enterprise.getName());
		existeCompania.setAddress(enterprise.getAddress());
		existeCompania.setPhone(enterprise.getPhone());
		existeCompania.setModifiedBy(enterprise.getModifiedBy());
		existeCompania.setModifiedDate(new Date());
		enterpriseDao.save(existeCompania);
		return existeCompania;
	}

}
