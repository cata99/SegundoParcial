package ar.edu.arqSoft.ticketService.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional

public class UserDaoTest{

	private static final Logger logger = LogManager.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testRegister() throws BadRequestException {

		logger.info("Test de Registro de user 1");
		User socio = new User();
		socio.setName("Pedro");
		socio.setLastName("lopez");
		socio.setEmail("hola@");


		userDao.insert(socio);
		Assert.assertNotNull(socio.getId());
		return;
	}
}