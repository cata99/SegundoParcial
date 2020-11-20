package ar.edu.arqSoft.ticketService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.ProyectService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class ProyectServiceTest{
	
	@Autowired
	private ProyectService proyectService;
	
	@Test
	public void testInsert() throws EntityNotFoundException,BadRequestException{
		
		ProyectRequestDto request = new ProyectRequestDto();
		
		request.setName("Proyecto 1");
		request.setDescription("Description 1");
		//como seteo las fechas?
		
		ProyectResponseDto response = proyectService.insertProyect(request);
		
		Assert.assertNotNull(response.getName());
		return;
	}
}