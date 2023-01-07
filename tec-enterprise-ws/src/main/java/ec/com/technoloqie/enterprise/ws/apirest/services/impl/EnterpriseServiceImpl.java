package ec.com.technoloqie.enterprise.ws.apirest.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Enterprise;
import ec.com.technoloqie.enterprise.ws.apirest.services.IEnterpriseService;

public class EnterpriseServiceImpl implements IEnterpriseService{

	@Override
	public List<Enterprise> getListEnterprises() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Enterprise> getListEnterprises(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enterprise createEnterprises(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enterprise getEnterpriseId(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEnterprise(Integer code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enterprise updateEnterprise(Enterprise enterprise, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
