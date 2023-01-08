package ec.com.technoloqie.enterprise.ws.apirest.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ec.com.technoloqie.enterprise.ws.apirest.entities.Enterprise;

public interface IEnterpriseService {
	
	List<Enterprise> getListEnterprises();
	//Page<Enterprise> getListEnterprises(Pageable pageable);
	Enterprise createEnterprises(Enterprise enterprise);
	Enterprise getEnterpriseId(Integer code);
    void deleteEnterprise(Integer code);
    Enterprise updateEnterprise(Enterprise enterprise, int id);

}
