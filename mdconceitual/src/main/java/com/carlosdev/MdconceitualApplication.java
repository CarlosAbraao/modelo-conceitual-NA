package com.carlosdev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carlosdev.domain.Categoria;
import com.carlosdev.domain.Produto;
import com.carlosdev.repository.CategoriaRepository;
import com.carlosdev.repository.ProdutoRepository;

@SpringBootApplication
public class MdconceitualApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MdconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria (null, "Eletrodoméstico");
		
		Produto prod1 = new Produto(null, "Computador", 2400.00);
		Produto prod2 = new Produto (null, "Impressora", 800.00);
		Produto prod3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		
		
		
		
	}

}
