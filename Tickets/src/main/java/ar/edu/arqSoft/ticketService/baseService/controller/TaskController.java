package ar.edu.arqSoft.ticketService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.arqSoft.ticketService.baseService.dto.AssignStateTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignStateTaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.AssignUserTaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.TaskService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/task")
public class TaskController{
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
		public @ResponseBody TaskResponseDto register(@RequestBody TaskRequestDto request) {
					try {
							TaskResponseDto dto = (TaskResponseDto) taskService.insertTask(request);
							return dto;
					} catch (EntityNotFoundException e) {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
					} catch (BadRequestException e) {
							throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
					}
	}
	
	@RequestMapping(value="/changeState", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody AssignStateTaskResponseDto changeState(@RequestBody AssignStateTaskRequestDto request){
			try {
				AssignStateTaskResponseDto dto =(AssignStateTaskResponseDto) taskService.changeState(request);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody AssignUserTaskResponseDto addUser(@RequestBody AssignUserTaskRequestDto request){
			try {
				AssignUserTaskResponseDto dto =(AssignUserTaskResponseDto) taskService.addUser(request);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	
	@RequestMapping(value="/getAllTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TaskResponseDto> getAllTask() {
		return taskService.getAllTask();
	}
}