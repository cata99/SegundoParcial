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
import ar.edu.arqSoft.ticketService.baseService.dto.CommentTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentTaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;
import ar.edu.arqSoft.ticketService.baseService.model.Task;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentRequestDto;

@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentDao commentDao;

	public CommentResponseDto insertComment(CommentRequestDto request)
			throws EntityNotFoundException, BadRequestException {
		return;

	}

	public List<CommentResponseDto> getAll() throws EntityNotFoundException, BadRequestException {
		List<Comment> comments = commentDao.getAll();
		List<CommentResponseDto> response = new ArrayList<CommentResponseDto>();
		for (Comment comment : comments) {
			if (comment.getId() <= 0) {
				throw new BadRequestException();
			}
			response.add((CommentResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentResponseDto()));
		}
		return response;
	}
	
	public List<CommentTaskResponseDto> getAllByTask(CommentTaskRequestDto req){
		List<Comment> comments = commentDao.getAllByTaskId(req.getIdTask());
		List<CommentTaskResponseDto> response = new ArrayList<CommentTaskResponseDto>();
		for (Comment comment : comments) {
			response.add((CommentTaskResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentTaskResponseDto()));
		}
		return response;
	}
	
}