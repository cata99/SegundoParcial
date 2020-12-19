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
import ar.edu.arqSoft.ticketService.baseService.dto.CommentRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.model.Comment;



@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentDao commentDao;

	public CommentResponseDto insertComment(CommentRequestDto request) throws EntityNotFoundException, BadRequestException {
		Comment comment = (Comment) new ModelDtoConverter().convertToEntity(new Comment(), request);
		
		try {
			commentDao.insert(comment);
		} catch (BadRequestException e) {
			throw new BadRequestException();
		}
		
		CommentResponseDto response = (CommentResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentResponseDto());
		return response;
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
	
	public List<CommentResponseDto> getAllByTask(CommentTaskRequestDto req){
		List<Comment> comments = commentDao.getAllByTaskId(req.getIdTask());
		List<CommentResponseDto> response = new ArrayList<CommentResponseDto>();
		for (Comment comment : comments) {
			response.add((CommentResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentResponseDto()));
		}
		return response;
	}
	
}