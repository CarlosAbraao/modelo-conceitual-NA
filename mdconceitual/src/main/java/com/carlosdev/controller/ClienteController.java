package com.carlosdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosdev.domain.Cliente;
import com.carlosdev.service.ClienteService;



@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService cliService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>  find(@PathVariable Integer id) {
		
		Cliente obj = cliService.busca(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	

}