package model.dao.impl.test;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoJDBCTest {
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	Department dep;
	
	@Before
	public void cenario() {
		dep = new Department(null,"Music");
	}
	
	@Test
	public void testA_insert() {
		departmentDao.insert(dep);
		Assert.assertEquals("Music", dep.getName());
		Assert.assertEquals(16, dep.getId(), 0);
	}
	
	@Test
	public void testB_deleteInvalido() {
		departmentDao.deleteById(20);
		Assert.assertThat(20, CoreMatchers.is("Invalid id"));
	}

}
