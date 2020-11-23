package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.CommentDao;
import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.StateDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
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
	private ProyectDao proyectDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private StateDao stateDao;
	@Autowired
	private CommentDao commentDao;
	
	public TaskResponseDto insertTask (TaskRequestDto request) throws BadRequestException, EntityNotFoundException{
		
		Task task = new Task();
		
		task.setName(request.getName());
		task.setDescription(request.getDescription());
		task.setProyect(proyectDao.load(request.getIdProyect()));
		task.setState(stateDao.load(request.getIdState()));
		
		taskDao.insert(task);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response.setName(task.getName());
		response.setDescription(task.getDescription());
		response.setProyect(task.getProyect());
		response.setState(task.getState());
		
		return response;	
			
	}
	
	public TaskResponseDto changeState(TaskRequestDto request, Long id ) throws BadRequestException, EntityNotFoundException
	{
		
		Task task = taskDao.load(request.getId());
		
		task.setState(stateDao.load(id));
		
		taskDao.saveOrUpdate(task);
		
		Comment comment= new Comment();
		
		comment.setDescription("Se cambio el estado de la tarea");
		comment.setUser(userDao.load(null));
		comment.setState(true);
		comment.setTask(taskDao.load(request.getId()));
		
		commentDao.insert(comment);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response = (TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto());
		
		return response;
		
	}
	
	public TaskResponseDto addUser(TaskRequestDto req, Long userId) throws BadRequestException, EntityNotFoundException
	{
		Task task = taskDao.load(req.getId());
		
		if (userId<=0 )
		{ 
			throw new BadRequestException();
		}
		
		task.setUsers(userDao.load(userId));
		
		taskDao.update(task);
		
		Comment comment= new Comment();
		
		comment.setDescription("Se agrego un nuevo usuario");
		comment.setUser(userDao.load(null));
		comment.setState(true);
		comment.setTask(taskDao.load(req.getId()));
		
		commentDao.insert(comment);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response = (TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto());
		
		return response;
		
	}
	
	
	public List<TaskResponseDto> getByName(String name) throws BadRequestException, EntityNotFoundException {
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
