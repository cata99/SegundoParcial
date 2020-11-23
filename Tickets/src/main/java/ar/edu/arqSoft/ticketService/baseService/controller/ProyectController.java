package ar.edu.arqSoft.ticketService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.arqSoft.ticketService.baseService.dto.ProyectResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.ProyectRequestDto;
import ar.edu.arqSoft.ticketService.baseService.services.ProyectService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/proyect")
public class ProyectController{

	@Autowired
	private ProyectService proyectService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
		public @ResponseBody ProyectResponseDto register(@RequestBody ProyectRequestDto request) {
					try {
							ProyectResponseDto dto = (ProyectResponseDto) proyectService.insertProyect(request);
							return dto;
					} catch (EntityNotFoundException e) {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyect Not Found", e);
					} catch (BadRequestException e) {
							throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
					}
	}
	
	@RequestMapping(value="/addUser/{id]}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody ProyectResponseDto addUser(@RequestBody UserRequestDto request, @PathVariable("id") Long id){
			try {
				ProyectResponseDto dto =(ProyectResponseDto) proyectService.addUser(request, id);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	@RequestMapping(value="/addTask/{id]}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody ProyectResponseDto addUser(@RequestBody TaskRequestDto request, @PathVariable("id") Long id){
			try {
				ProyectResponseDto dto =(ProyectResponseDto) proyectService.addTask(request, id);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{name}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody List<ProyectResponseDto> getbyName(@PathVariable("name") String name){
			try {
				ProyectResponseDto dto =(ProyectResponseDto) proyectService.GetByName(name);		
				return (List<ProyectResponseDto>) dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyect Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
}
