package model.dao.impl.test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBCTest {
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	Department dep;
	
	@Before
	public void cenario() {
		dep = new Department(null,"Music");
	}
	
	@Test
	public void insereDepartment() {
		//acao
		departmentDao.insert(dep);
		
		//verificacao
		assertThat(dep.getId(), is(21));
	}
	
//	@Test(expected = SQLException.class)
//	public void naoInsereDepartmentException() {
//		//cenario
//		Department obj = new Department();
//		
//		//acao
//		departmentDao.insert(obj);		
//	}

	

}
