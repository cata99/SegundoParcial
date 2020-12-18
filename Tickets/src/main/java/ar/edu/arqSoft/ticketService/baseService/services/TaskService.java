package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import ar.edu.arqSoft.ticketService.baseService.model.Proyect;
import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.baseService.model.User;
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
		task.setUser(userDao.load(request.getIdUser()));
		
		try {
			taskDao.insert(task);
		} catch (BadRequestException e ){
			throw new BadRequestException();
		}
		
		
		TaskResponseDto response = new TaskResponseDto();
		
		response.setId(task.getId());
		response.setName(task.getName());
		response.setDescription(task.getDescription());
		response.setUserName(task.getUser().getName());
		response.setUserLastname(task.getUser().getLastName());
		response.setIdUser(task.getUser().getId());
		response.setIdProyect(task.getProyect().getId());
		response.setProyectName(task.getProyect().getName());
		response.setIdState(task.getState().getId());
		response.setStateName(task.getState().getName());

		Comment comment= new Comment();
		comment.setDescription("Se creo una nueva tarea");
		comment.setTask(task);
		commentDao.insert(comment);
		
		return response;	
			
	}
	
	public TaskResponseDto changeState(TaskRequestDto request, Long id ) throws BadRequestException, EntityNotFoundException
	{
		
		Task task = taskDao.load(request.getId());
		
		task.setState(stateDao.load(id));
		
		taskDao.update(task);
		
		Comment comment= new Comment();
		
		comment.setDescription("Se cambio el estado de la tarea");
		comment.setTask(task);
		
		commentDao.insert(comment);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response = (TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto());
		
		return response;
		
	}
	
	public TaskResponseDto addUser(TaskRequestDto req) throws BadRequestException, EntityNotFoundException
	{
		Task task = taskDao.load(req.getId());
		
		if (req.getIdUser()<=0 )
		{ 
			throw new BadRequestException();
		}
		Proyect project = task.getProyect();
		Set<User> project_users = project.getUsers();
		User user = userDao.load(req.getIdUser());
		if (!project_users.contains(user))
			throw new BadRequestException();
		
		task.setUser(userDao.load(req.getIdUser()));
		
		taskDao.update(task);
		
		Comment comment= new Comment();
		
		comment.setDescription("Se agrego un nuevo usuario");
		comment.setUser(userDao.load(null));
		comment.setTask(taskDao.load(req.getId()));
		
		commentDao.insert(comment);
		
		TaskResponseDto response = new TaskResponseDto();
		
		response = (TaskResponseDto) new ModelDtoConverter().convertToDto(task,new TaskResponseDto());
		
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
