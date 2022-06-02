package com.carlosdev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdev.domain.Categoria;
import com.carlosdev.repository.CategoriaRepository;
import com.carlosdev.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	
	public Categoria busca(Integer id) {
		
		Optional<Categoria> objCat = catRepo.findById(id);
		
		return objCat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: " +id + ",Tipo: "+ Categoria.class.getName()) );
	}
	
	

}
