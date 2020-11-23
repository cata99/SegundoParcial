package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.ticketService.baseService.dao.CommentDao;
import ar.edu.arqSoft.ticketService.baseService.dao.TaskDao;
import ar.edu.arqSoft.ticketService.baseService.dao.UserDao;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentRequestDto;


@Service
@Transactional
public class CommentService{
	
	@Autowired
	private CommentDao commentDao;
	
	private TaskDao taskDao;
	
	private UserDao userDao;
	
	public CommentResponseDto insertComment (CommentRequestDto request) throws EntityNotFoundException, BadRequestException{
	
		Task task=taskDao.load(request.getIdTask());
		
		if (task.getState().getName() == "Finish")
		{
			throw new BadRequestException();
		}
		
		
		Comment comment = new Comment();
		
		comment.setDescription(request.getDescription());
		comment.setState(request.getState());
		comment.setUser(userDao.load(request.getIdUser()));
		comment.setTask(taskDao.load(request.getIdTask()));
		
		commentDao.insert(comment);
		
		CommentResponseDto response = new CommentResponseDto();
		
		response.setDescription(comment.getDescription());
		response.setState(comment.getState());
		response.setUser(comment.getUser());
		response.setTask(comment.getTask());
		
		return response;
		
	}
	
	
	public List<CommentResponseDto> getAll() throws EntityNotFoundException, BadRequestException{
		List<Comment> Comments = commentDao.getAll();
		List<CommentResponseDto> response = new ArrayList<CommentResponseDto>();
		for (Comment Comment : Comments) {
			if (Comment.getId() <= 0) {
				throw new BadRequestException();
			}
			response.add((CommentResponseDto) new ModelDtoConverter().convertToDto(Comment, new CommentResponseDto()));
			}
		return response;
	}
	
	

}