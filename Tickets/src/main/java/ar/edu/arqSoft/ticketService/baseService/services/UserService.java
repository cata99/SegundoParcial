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

	public UserResponseDto InsertUser(UserRequestDto request) throws BadRequestException {
		User user = (User) new ModelDtoConverter().convertToEntity(new User(), request);
		try {
			userDao.insert(user);
		} catch (BadRequestException e) {
			throw new BadRequestException();
		}
		UserResponseDto response = (UserResponseDto) new ModelDtoConverter().convertToDto(user, new UserResponseDto());
		return response;
	}

	public List<UserResponseDto> getAllUser() {
		List<User> users = userDao.getAll();

		List<UserResponseDto> response = new ArrayList<UserResponseDto>();

		for (User user : users) {
			response.add((UserResponseDto) new ModelDtoConverter().convertToDto(user, new UserResponseDto()));
		}

		return response;
	}

	public UserResponseDto getUserById(Long id) throws EntityNotFoundException, BadRequestException {

		if (id <= 0) {
			throw new BadRequestException();
		}
		User user = userDao.load(id);

		UserResponseDto response = new UserResponseDto();

		response.setId(user.getId());
		response.setName(user.getName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		return response;
	}

	

}