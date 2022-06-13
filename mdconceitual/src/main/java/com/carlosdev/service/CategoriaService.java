package com.carlosdev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.carlosdev.domain.Categoria;
import com.carlosdev.repository.CategoriaRepository;
import com.carlosdev.service.exception.DataIntegrityException;
import com.carlosdev.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> objCat = catRepo.findById(id);
		
		return objCat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: " +id + ",Tipo: "+ Categoria.class.getName()) );
	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return catRepo.save(categoria);
	}

	public Categoria update(Categoria objCategoria) {
		
		// TESTANDO SE O ID EXISTE
		find(objCategoria.getId());
		
		// ATUALIZANDO A CATEGORIA
		return catRepo.save(objCategoria);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		
		try {
		 catRepo.deleteById(id);
		}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
			}
		
	}
	
	

}
