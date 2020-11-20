package ar.edu.arqSoft.ticketService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.TaskService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class TaskServiceTest{
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void insertTask() throws EntityNotFoundException, BadRequestException {
		
		TaskRequestDto request = new TaskRequestDto();
		request.setName("tarea 1");
		request.setDescription("esta es la description");	
		
		TaskResponseDto response = taskService.insertTask(request);
		Assert.assertNotNull(response.getName());
		return;
	}
		
	}
