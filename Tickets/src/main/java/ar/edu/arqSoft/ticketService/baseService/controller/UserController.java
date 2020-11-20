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
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.arqSoft.ticketService.baseService.dto.UserResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.UserService;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	 @SuppressWarnings("unchecked")
	 @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(code= HttpStatus.CREATED)
	 public @ResponseBody List<UserResponseDto> getAll(){
			try {
				UserResponseDto dto =(UserResponseDto) userService.;		
				return (List<UserResponseDto>) dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film Not Found", e);
			} catch (BadRequestException) { 
				
			}
}