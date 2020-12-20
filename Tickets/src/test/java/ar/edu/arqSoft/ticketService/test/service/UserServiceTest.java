package ar.edu.arqSoft.ticketService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.UserService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class UserServiceTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testInsert() throws EntityNotFoundException, BadRequestException {
		UserRequestDto request = new UserRequestDto();
		request.setName("hola");
		request.setEmail("hola@");
		request.setLastName("hi");
		request.setId((long) 1);
		
		UserResponseDto response = userService.insertUser(request);
		
		Assert.assertNotNull(response.getName());
		return;
	}
}