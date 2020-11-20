package ar.edu.arqSoft.ticketService.baseService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.UserRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.UserResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.User;

@Service
@Transactional
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	public UserResponseDto InsertUser (UserRequestDto request)
	{
		User user = new User();
		
		user.setName(request.getName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setUserName(request.getUserName());
		
		userDao.insert(user);
		
		UserResponseDto response = new UserResponseDto();
		
		response.setName(user.getName());
		response.setLastName(user.getLastName());
		response.setUserName(user.getUserName());
		response.setEmail(user.getEmail());
		
		return response;
	}
}