package ec.com.technoloqie.enterprise.ws.apirest.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.com.technoloqie.enterprise.ws.apirest.dao.IDepartmentDao;
import ec.com.technoloqie.enterprise.ws.apirest.entities.Department;
import ec.com.technoloqie.enterprise.ws.apirest.services.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Autowired
	private IDepartmentDao departmentDao;

	@Override
	@Transactional(readOnly = true)
	public List<Department> getListDepartment() {
		return departmentDao.findAll();
	}

	@Override
	@Transactional
	public Department createDepartment(Department department) {
		return departmentDao.save(department);
	}

	@Override
	@Transactional(readOnly = true)
	public Department getDepartmentId(Integer code) {
		return departmentDao.findById(code).orElse(null);
	}

	@Override
	@Transactional
	public void deleteDepartment(Integer code) {
		departmentDao.deleteById(code);
	}

	@Override
	@Transactional
	public Department updateDepartment(Department department, int id) {
		Department existeDept = getDepartmentId(id); //tenemos que comprobar si con la identificación dada existe en la db o no
		existeDept.setName(department.getName());
		existeDept.setDescription(department.getDescription());
		existeDept.setPhone(department.getPhone());
		existeDept.setModifiedBy(department.getModifiedBy());
		existeDept.setModifiedDate(new Date());
		departmentDao.save(existeDept);
		return existeDept;
	}

}
