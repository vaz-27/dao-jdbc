package model.dao.impl.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBCTest {
	@InjectMocks
	SellerDao sellerdao = DaoFactory.createSellerDao();
	DepartmentDao depdao = DaoFactory.createDepartmentDao();
	@Mock
	Seller seller;		
	
	@Before
	public void cenario() {
		initMocks(this);
	}
	
	@Test(expected = db.DbException.class)
	public void deletandoById() {
		//cenario
		seller.setId(100);
		
		//acao
		sellerdao.deleteById(100);
		
		//verificacao
		sellerdao.findById(100);
	}
	
	@Test
	public void encontrandoById() {
		//acao
		Seller sel = sellerdao.findById(1);
		
		//verificacao
		assertThat(sel.getName(), containsString("Marta Wayne"));
	}
	
	@Test
	public void encontrandoByDep() {
		//cenario
			Department dep = depdao.findById(3);
		//acao
		List<Seller> sel = sellerdao.findByDepartment(dep);
		
		//verificacao
		for (Seller seller : sel) {
			assertThat(seller.getId(), is(5));
		}
	}
}
