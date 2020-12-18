package ar.edu.arqSoft.ticketService.baseService.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.CommentDao;
import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.model.*;
import ar.edu.arqSoft.ticketService.common.dto.*;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class ProyectService{
	
	@Autowired
	private ProyectDao proyectDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private CommentDao commentDao;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public ProyectResponseDto insertProyect (ProyectRequestDto request) throws BadRequestException, EntityNotFoundException {
		
		Proyect proyect = (Proyect) new ModelDtoConverter().convertToEntity(new Proyect(), request);
		
		try {
			proyectDao.insert(proyect);
			}
			catch(BadRequestException e){
				throw new BadRequestException();
			}
		
		ProyectResponseDto response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect, new ProyectResponseDto());	
		
		return response;
		
	}
	
	public ProyectResponseDto addUser (UserRequestDto req, Long proyectid)throws BadRequestException, EntityNotFoundException {
		
		if(proyectid<=0)
		{
			throw new BadRequestException();
		}
	
		Proyect proyect = proyectDao.load(proyectid);
		
		proyect.setUsers(userDao.load(req.getId()));
		
		Comment comment= new Comment();
		
		comment.setDescription("Se agrego un nuevo usuario");
		comment.setUser(userDao.load(null));
		comment.setTask(null);
		
		commentDao.insert(comment);
		
		ProyectResponseDto response = new ProyectResponseDto();
		
		response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,new ProyectResponseDto());
		
		return response;
	}
	
	
	public ProyectResponseDto addTask (TaskRequestDto req, Long proyectid) throws BadRequestException, EntityNotFoundException{
		if(proyectid<=0)
		{
			throw new BadRequestException();
		}
		Proyect proyect = proyectDao.load(proyectid);		
	
		proyect.setTasks(taskDao.load(req.getId()));
		
		Comment comment= new Comment();
		
		comment.setDescription("Se agrego una nueva tarea al proyecto");
		comment.setUser(userDao.load(null));
		comment.setTask(null);
		
		
		commentDao.insert(comment);
		
		ProyectResponseDto response = new ProyectResponseDto();
		
		response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,new ProyectResponseDto());
		
		return response;
	}
	
	
	public List<ProyectResponseDto> GetByName(String name) throws BadRequestException, EntityNotFoundException{
		List<Proyect> proyects = proyectDao.FindByName(name);
		
		List<ProyectResponseDto> response = new ArrayList<ProyectResponseDto>();
		for(Proyect proyect: proyects) {
			if(proyect.getId()<=0)
			{
				throw new BadRequestException();
			}
		response.add((ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,new ProyectResponseDto()));
		}
		return response;
	}
	
	
	   
	   public List<ProyectResponseDto> getAllProyect() {
			List<Proyect> proyects = proyectDao.getAll();
			
			List<ProyectResponseDto> response = new ArrayList<ProyectResponseDto>();
			 
			for (Proyect proyect : proyects) {
				response.add((ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect, new ProyectResponseDto()));
			}
			
			return response;
		}
	
}