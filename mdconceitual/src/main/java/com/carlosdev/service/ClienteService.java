package com.carlosdev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdev.domain.Cliente;
import com.carlosdev.repository.ClienteRepository;
import com.carlosdev.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository catRepo;
	
	
	public Cliente busca(Integer id) {
		
		Optional<Cliente> objCat = catRepo.findById(id);
		
		return objCat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: " +id + ",Tipo: "+ Cliente.class.getName()) );
	}
	
	

}
