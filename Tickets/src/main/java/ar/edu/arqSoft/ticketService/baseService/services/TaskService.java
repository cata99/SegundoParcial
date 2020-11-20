package ar.edu.arqSoft.ticketService.baseService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Task;

@Service
@Transactional

public class TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	private ProyectDao proyectDao;
	
	private UserDao userDao;
	
	public TaskResponseDto insertTask (TaskRequestDto request) {
		
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
}
