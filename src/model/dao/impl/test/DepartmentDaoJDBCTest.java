package model.dao.impl.test;


import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBCTest {
	@InjectMocks
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	@Mock
	Department dep;

	@Rule
	public ExpectedException exception =  ExpectedException.none();
	
	@Before
	public void cenario() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void inserindoDepartment() {
		//cenario
		Mockito.when(dep.getName()).thenReturn("Aprendizagem");
		
		//acao
		departmentDao.insert(dep);
		
		//verificacao
		Assert.assertThat(dep.getName(),CoreMatchers.is("Aprendizagem"));
	}
	

	@Test
	public void updateDepartment() {
		//cenario
		Department obj = new Department(null, "abc");
		departmentDao.insert(obj);
		obj.setName("Learning");
		
		//acao
		departmentDao.update(obj);
		
		//verificacao
		Assert.assertEquals("Learning",obj.getName());	
	}
	
	@Test
	public void encontraPorId() {
		//acao
		Department obj = departmentDao.findById(1);
		
		//verificacao
		Assert.assertEquals("Computers",obj.getName());
	}

	@Test
	public void findAll() {
		//acao
		List<Department> lista = departmentDao.findAll();
		
		//verificacao
		Assert.assertNotNull(lista);
	}
	
	@Test(expected = db.DbException.class)
	public void deletarPorId() {
		//cenario
		dep.setId(100);
		departmentDao.update(dep);
		
		//acao
		departmentDao.deleteById(100);
		departmentDao.findById(100);		
	}
}
