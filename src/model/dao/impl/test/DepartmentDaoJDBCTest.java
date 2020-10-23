package model.dao.impl.test;

import org.junit.Assert;
import org.junit.Test;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBCTest {
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	@Test
	public void insertValidoTest() {
		System.out.println("Iniciou o teste!");
		Department dep = new Department(null, "Music");
		departmentDao.insert(dep);
		//Integer id = dep.getId();
		Assert.assertEquals(13,dep.getId());
	}

}
