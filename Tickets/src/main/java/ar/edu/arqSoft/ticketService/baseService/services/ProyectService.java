package ar.edu.arqSoft.ticketService.baseService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Proyect;

@Service
@Transactional
public class ProyectService{
	
	@Autowired
	private ProyectDao proyectDao;
	
	private UserDao userDao;
	
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
	
}