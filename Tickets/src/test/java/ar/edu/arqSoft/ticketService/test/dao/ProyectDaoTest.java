package ar.edu.arqSoft.ticketService.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.model.Proyect;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class ProyectDaoTest{
	
private static final Logger logger = LogManager.getLogger(ProyectDaoTest.class);
	
	@Autowired
	private ProyectDao proyectDao;
	
	@Test
	public void testRegister() throws BadRequestException {

		logger.info("Test de Registro de proyecto 1");
		Proyect proyect = new Proyect();
		
		proyect.setName("Proyecto 1");
		proyect.setDescription("Aca soy re piola angelo");
	
		proyectDao.insert(proyect);
		Assert.assertNotNull(proyect.getId());
		return;
	}
}