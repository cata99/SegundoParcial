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

import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.UserService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody UserResponseDto register(@RequestBody UserRequestDto request) {
		try {
			UserResponseDto dto = (UserResponseDto) userService.InsertUser(request);
			return dto;
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserResponseDto> getAllUser() {
		return userService.getAllUser();
	}

	@RequestMapping(value = "usersFromProyect/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserResponseDto getById(@PathVariable("id") Long id) {
		try {
			UserResponseDto dto = (UserResponseDto) userService.getUserById(id);
			return dto;
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
		} catch (EntityNotFoundException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
	}

	}
}
