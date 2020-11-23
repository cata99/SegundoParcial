package ar.edu.arqSoft.ticketService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.ticketService.baseService.dao.StateDao;
import ar.edu.arqSoft.ticketService.baseService.dto.StateResponseDto;
import ar.edu.arqSoft.ticketService.baseService.model.State;
import ar.edu.arqSoft.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class StateService{
	
	@Autowired
	private StateDao stateDao;	

	public List<StateResponseDto> getByName(String name) throws EntityNotFoundException, BadRequestException {
		List<State> states = stateDao.FindByName(name);
		
		List<StateResponseDto> response = new ArrayList<StateResponseDto>();
		for(State state: states) 
		{
			if(state.getId()<=0)
			{
				throw new BadRequestException();
			}
		response.add((StateResponseDto) new ModelDtoConverter().convertToDto(state,new StateResponseDto()));
		}
		return response;
	}
}