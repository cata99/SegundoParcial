package ar.edu.arqSoft.ticketService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.arqSoft.ticketService.baseService.services.StateService;

@Controller
@RequestMapping("/state")
public class StateController{
	
	@Autowired
	private StateService stateService;
	
}