package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.common.dto.*;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Service
@Transactional

public class TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	private ProyectDao proyectDao;
	
	private UserDao userDao;
	
	public TaskResponseDto insertTask (TaskRequestDto request) throws BadRequestException, EntityNotFoundException{
		
		Task task = new Task();
		
		task.setName(request.getName());
		task.setDescription(request.getDescription());
		task.setProyect(proyectDao.load(request.getIdProyect()));
		task.setOwner(userDao.load(request.getIdOwner()));
		
		taskDao.insert(task);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response.setName(task.getName());
		response.setDescription(task.getDescription());
		response.setProyect(task.getProyect());
		response.setOwner(task.getOwner());
		
		return response;	
			
	}
	public List<TaskResponseDto> GetByName(String name) throws BadRequestException, EntityNotFoundException {
		List<Task> tasks = taskDao.FindByName(name);
		
		List<TaskResponseDto> response = new ArrayList<TaskResponseDto>();
		for(Task task: tasks) {
			if (task.getId()<=0)
			{
				throw new BadRequestException();
			}
		response.add((TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto()));
		}
		return response;
	}
}
