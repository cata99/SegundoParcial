package ar.edu.arqSoft.ticketService.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.CommentDao;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class CommentDaoTest{
	
	private static final Logger logger = LogManager.getLogger(CommentDaoTest.class);
	
	@Autowired
	private CommentDao commentDao;

	@Test
	public void testRegister() throws BadRequestException {

		logger.info("Test de Registro de comentario 1");
		Comment comment = new Comment();
		comment.setDescription("Hola Como estas");
		
		commentDao.insert(comment);
		Assert.assertNotNull(comment.getId());
		return;
	}
}