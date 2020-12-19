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
import ar.edu.arqSoft.ticketService.baseService.dto.CommentRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentResponseDto;
import ar.edu.arqSoft.ticketService.baseService.dto.CommentTaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.services.CommentService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody CommentResponseDto register(@RequestBody CommentRequestDto request) {
		try {
			CommentResponseDto dto = (CommentResponseDto) commentService.insertComment(request);
			return dto;
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment Not Found", e);
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CommentResponseDto> getAll() {
		try {
			List<CommentResponseDto> dto = commentService.getAll();
			return (List<CommentResponseDto>) dto;
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment Not Found", e);
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getbyTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CommentResponseDto> getByTask(@RequestBody CommentTaskRequestDto request) {

		CommentResponseDto dto = (CommentResponseDto) commentService.getAllByTask(request);
		return (List<CommentResponseDto>) dto;

	}
}
