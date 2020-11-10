package model.dao.impl.test;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class DepartmentDaoJDBCTest {
	@InjectMocks
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	@Mock
	Department dep;
	@Mock
	DepartmentDaoJDBC table;

	
	@Before
	public void cenario() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void insereDepartment() {
		//cenario
		Mockito.when(dep.getName()).thenReturn("Aprendizagem");
		
		//acao
		departmentDao.insert(dep);
		
		//verificacao
		Assert.assertThat(dep.getName(),CoreMatchers.is("Aprendizagem"));
		
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
