package com.carlosdev.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosdev.domain.Categoria;
import com.carlosdev.service.CategoriaService;



@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService catService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?>  find(@PathVariable Integer id) {
		
		Categoria obj = catService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria objCategoria){
		// VOU CRIAR UMA NOVA CATEGORIA
		objCategoria = catService.insert(objCategoria);
		
		// CRIAR UM CAMINHO, UMA URI PARA A CATEGORIA CRIADA
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria objCategoria, @PathVariable Integer id){
		objCategoria.setId(id);
		objCategoria = catService.update(objCategoria);
		return ResponseEntity.noContent().build();
	}
	

}
