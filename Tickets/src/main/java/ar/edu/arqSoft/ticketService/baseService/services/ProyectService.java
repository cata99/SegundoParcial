package ar.edu.arqSoft.ticketService.baseService.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.ProyectDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.*;
import ar.edu.arqSoft.ticketService.common.dto.*;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class ProyectService {

	@Autowired
	private ProyectDao proyectDao;

	@Autowired
	private UserDao userDao;

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ProyectResponseDto insertProyect(ProyectRequestDto request)
			throws BadRequestException, EntityNotFoundException {

		Proyect proyect = (Proyect) new ModelDtoConverter().convertToEntity(new Proyect(), request);

		try {
			proyectDao.insert(proyect);
		} catch (BadRequestException e) {
			throw new BadRequestException();
		}

		ProyectResponseDto response = (ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,
				new ProyectResponseDto());

		return response;

	}

	public List<ProyectResponseDto> GetByName(String name) throws BadRequestException, EntityNotFoundException {
		List<Proyect> proyects = proyectDao.FindByName(name);

		List<ProyectResponseDto> response = new ArrayList<ProyectResponseDto>();
		for (Proyect proyect : proyects) {
			if (proyect.getId() <= 0) {
				throw new BadRequestException();
			}
			response.add((ProyectResponseDto) new ModelDtoConverter().convertToDto(proyect, new ProyectResponseDto()));
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

	public AssignUserProyectResponseDto addUser(AssignUserProyectRequestDto req)
			throws BadRequestException, EntityNotFoundException {

		if (req.getIdProyect() <= 0 || req.getIdUser() <= 0) {
			throw new BadRequestException();
		}

		Proyect proyect = proyectDao.load(req.getIdProyect());
		proyect.setUsers(userDao.load(req.getIdUser()));

		AssignUserProyectResponseDto response = new AssignUserProyectResponseDto();
		response = (AssignUserProyectResponseDto) new ModelDtoConverter().convertToDto(proyect,
				new AssignUserProyectResponseDto());

		return response;
	}
}