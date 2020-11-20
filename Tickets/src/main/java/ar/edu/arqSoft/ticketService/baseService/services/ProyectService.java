package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.model.Proyect;
import ar.edu.arqSoft.ticketService.common.dto.*;

@Service
@Transactional
public class ProyectService{
	
	@Autowired
	private ProyectDao proyectDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TaskDao taskDao;
	
	public ProyectResponseDto insertProyect (ProyectRequestDto request) {
		
		Proyect proyect= new Proyect();
		
		proyect.setName(request.getName());
		proyect.setDescription(request.getDescription());
		proyect.setStartDate(request.getStartDate());
		proyect.setFinishDate(request.getFinishDate());
		proyect.setOwner(userDao.load(request.getIdUser()));
		
		proyectDao.insert(proyect);
		
		ProyectResponseDto response = new ProyectResponseDto();
		
		response.setName(proyect.getName());
		response.setDescription(proyect.getDescription());
		response.setStartDate(proyect.getStartDate());
		response.setFinishDate(proyect.getFinishDate());
		response.setOwner(proyect.getOwner());
		
		return response; 
		
	}
	
	public ProyectResponseDto addUser (UserRequestDto req, Long proyectid) {
		Proyect proyect = proyectDao.load(proyectid);
		
		proyect.setUsers(userDao.load(req.getId()));
		
		ProyectResponseDto response = new ProyectResponseDto();
		
		response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,new ProyectResponseDto());
		
		return response;
	}
	
	
	public ProyectResponseDto addTask (TaskRequestDto req, Long proyectid) {
		Proyect proyect = proyectDao.load(proyectid);
		
		proyect.setTasks(taskDao.load(req.getId()));
		
		ProyectResponseDto response = new ProyectResponseDto();
		
		response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,new ProyectResponseDto());
		
		return response;
	}
	
	
	public List<ProyectResponseDto> GetByName(String name) {
		List<Proyect> Proyects = proyectDao.FindByName(name);
		
		List<ProyectResponseDto> response = new ArrayList<ProyectResponseDto>();
		for(Proyect Proyect: Proyects) {
		response.add((ProyectResponseDto) new ModelDtoConverter().convertToDto(Proyect,new ProyectResponseDto()));
		}
		return response;
	}
	
	
	
}