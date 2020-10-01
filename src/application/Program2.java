package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n\n=== TEST 2: department findAll ===");
		List<Department> listDep = departmentDao.findAll();
		
		for (Department dep : listDep) {
			System.out.println(dep);
		}
		
		System.out.println("\n\n=== TEST 3: department insert ===");
		Department newDep = new Department(null, "RH" );
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id "+ newDep.getId());
	}

}
