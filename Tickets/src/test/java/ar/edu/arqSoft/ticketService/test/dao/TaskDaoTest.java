package ar.edu.arqSoft.ticketService.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.model.Task;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class TaskDaoTest{


	private static final Logger logger = LogManager.getLogger(TaskDaoTest.class);
	
	@Autowired
	private TaskDao taskDao;
	
	@Test
	public void testRegister() {

		logger.info("Test de Registro de task 1");
		Task task = new Task();
		
		task.setName("1");
		task.setDescription("Hola");
	
		taskDao.insert(task);
		Assert.assertNotNull(task.getId());
		return;
	}
}