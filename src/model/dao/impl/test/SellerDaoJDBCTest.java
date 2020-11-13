package model.dao.impl.test;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerDaoJDBCTest {
	@InjectMocks
	SellerDao sellerdao = DaoFactory.createSellerDao();
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
}
