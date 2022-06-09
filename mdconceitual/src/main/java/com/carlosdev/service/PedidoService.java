package com.carlosdev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosdev.domain.Pedido;
import com.carlosdev.repository.PedidoRepository;
import com.carlosdev.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	
	public Pedido busca(Integer id) {
		
		Optional<Pedido> objCat = pedidoRepo.findById(id);
		
		return objCat.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: " +id + ",Tipo: "+ Pedido.class.getName()) );
	}
	
	

}
