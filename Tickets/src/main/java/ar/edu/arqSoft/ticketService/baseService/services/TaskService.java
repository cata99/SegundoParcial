package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.StateDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignStateTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignStateTaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserTaskResponseDto;
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
	@Autowired
	private UserDao userDao;
	@Autowired
	private StateDao stateDao;
	@Autowired
	private ProyectDao proyectDao;
	
	public TaskResponseDto insertTask (TaskRequestDto request) throws BadRequestException, EntityNotFoundException{
		
		Task task = new Task();
		
		task.setId(request.getId());
		task.setName(request.getName());
		task.setDescription(request.getDescription());
		task.setState(stateDao.load(request.getState()));
		task.setProyect(proyectDao.load(request.getState()));

		
		taskDao.insert(task);
		TaskResponseDto response = new TaskResponseDto();
		
		response.setId(task.getId());
		response.setName(task.getName());
		response.setDescription(task.getDescription());

		
		return response;	
			
	}
	
	public AssignStateTaskResponseDto changeState(AssignStateTaskRequestDto request ) throws BadRequestException, EntityNotFoundException
	{
		if (request.getIdState() <= 0 || request.getIdTask() <=0 )
			throw new BadRequestException();
		Task task= taskDao.load(request.getIdTask());
		task.setState(stateDao.load(request.getIdState()));
		
		AssignStateTaskResponseDto response= new AssignStateTaskResponseDto();
		response = (AssignStateTaskResponseDto) new ModelDtoConverter().convertToDto(task,new AssignStateTaskResponseDto());
		
		return response;
	}
	
	public AssignUserTaskResponseDto addUser(AssignUserTaskRequestDto request) throws BadRequestException, EntityNotFoundException
	{
		if (request.getIdUser() <= 0 || request.getIdTask() <=0 )
			throw new BadRequestException();
		Task task= taskDao.load(request.getIdTask());
		task.setUsers(userDao.load(request.getIdUser()));
		
		AssignUserTaskResponseDto response = new AssignUserTaskResponseDto();
		response = (AssignUserTaskResponseDto) new ModelDtoConverter().convertToDto(task, new AssignUserTaskResponseDto());
		
		return response;
	}
	
	
	public List<TaskResponseDto> getAllTask() {
		List<Task> tasks = taskDao.getAll();
		
		List<TaskResponseDto> response = new ArrayList<TaskResponseDto>();
		for(Task task: tasks) {
		response.add((TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto()));
		}
		return response;
	}
}
