package model.dao.impl.test;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
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
}
