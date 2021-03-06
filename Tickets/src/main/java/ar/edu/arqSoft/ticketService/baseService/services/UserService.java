package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserResponseDto insertUser(UserRequestDto request) throws BadRequestException {
		
		User user = new User();
		user.setId(request.getId());
		user.setName(request.getName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		
		userDao.insert(user);
		UserResponseDto response = new UserResponseDto();
		
		response.setName(user.getName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setId(user.getId());
		
		return response ;
	}

	public List<UserResponseDto> getAllUser() {
		List<User> users = userDao.getAll();

		List<UserResponseDto> response = new ArrayList<UserResponseDto>();

		for (User user : users) {
			response.add((UserResponseDto) new ModelDtoConverter().convertToDto(user, new UserResponseDto()));
		}

		return response;
	}

	public List<UserResponseDto> GetByName(String name) throws EntityNotFoundException, BadRequestException {
		
		List<User> users = userDao.FindByName(name);

		List<UserResponseDto> response = new ArrayList<UserResponseDto>();
		for (User user : users) {
			if (user.getId() <= 0) {
				throw new BadRequestException();
			}
			response.add((UserResponseDto) new ModelDtoConverter().convertToDto(user, new UserResponseDto()));
		}
		return response;
	}

}