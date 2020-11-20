package ar.edu.arqSoft.ticketService.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.StateDao;
import ar.edu.arqSoft.ticketService.baseService.model.Proyect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class StateDaoTest{
	
	private static final Logger logger = LogManager.getLogger(StateDaoTest.class);
	
	@Autowired
	private StateDao stateDao;
	
	@Test
	public void testRegister() {

		logger.info("Test de Registro de state 1");
		State state = new State();
		
		
	
		stateDao.insert(state);
		Assert.assertNotNull(state.getId());
		return;
	}
}