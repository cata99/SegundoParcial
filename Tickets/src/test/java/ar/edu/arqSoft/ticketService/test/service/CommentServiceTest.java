package ar.edu.arqSoft.ticketService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.arqSoft.ticketService.baseService.dto.CommentRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.CommentService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class CommentServiceTest{
	
	@Autowired
	private CommentService commentService;
	
	@Test
	public void testInsert() throws EntityNotFoundException, BadRequestException{
		
		CommentRequestDto request = new CommentRequestDto();
		request.setDescription("Description comment");
		
		CommentResponseDto response = commentService.insertComment(request);
		Assert.assertEquals("Description comment",response.getDescription());
		
	}
}