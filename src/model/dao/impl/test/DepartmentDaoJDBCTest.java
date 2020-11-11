package model.dao.impl.test;


import static org.hamcrest.CoreMatchers.is;

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
		dep.setName("Aprendizagem");
		Mockito.when(dep.getName()).thenReturn("Music");
		
		//acao
		departmentDao.update(dep);
		
		//verificacao
		Assert.assertThat(dep.getName(), is("Music"));
	}

}
