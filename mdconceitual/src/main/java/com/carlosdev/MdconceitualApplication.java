package com.carlosdev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carlosdev.domain.Categoria;
import com.carlosdev.domain.Cidade;
import com.carlosdev.domain.Cliente;
import com.carlosdev.domain.Endereco;
import com.carlosdev.domain.Estado;
import com.carlosdev.domain.Produto;
import com.carlosdev.domain.enums.TipoCliente;
import com.carlosdev.repository.CategoriaRepository;
import com.carlosdev.repository.CidadeRepository;
import com.carlosdev.repository.ClienteRepository;
import com.carlosdev.repository.EnderecoRepository;
import com.carlosdev.repository.EstadoRepository;
import com.carlosdev.repository.ProdutoRepository;

@SpringBootApplication
public class MdconceitualApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

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
		
		// POPULANDO ESTADO 
		
		Estado est1 = new Estado(null,"Maranhão");
		Estado est2 = new Estado(null, "São Paulo");
		
		// POPULANDO CIDADE E RELACIONANDO 
		
		Cidade cid1 = new Cidade(null,"São Luís",est1);
		Cidade cid2 = new Cidade (null, "São Paulo",est2);
		Cidade cid3 = new Cidade (null, "Imperatriz",est1);
		
		
		// RELACIONANDO ESTADO COM CIDADE
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid3));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		
		
		//CRIANDO CLIENTE
		
		Cliente cli1 = new Cliente(null,"Carlos Abraão","carloschavesnd@gmail.com","321.546.484.58",TipoCliente.PESSOAFISICA);
		
		//ADICIONANDO O TELEFONE AO CLIENTE
		
		cli1.getTelefones().addAll(Arrays.asList("983259-4578", "989654-89652"));
		
		//CRIANDO E ADICIONANDO ENDEREÇO AO CLIENTE
		
		Endereco e1 = new Endereco(null, "Alameda Porto Molhado", "250", "Casa", "Jardim", "3254574", cli1, cid1);
		Endereco e2 = new Endereco(null, "Arnoldo Materiz", "30", "Casa", "Jardim", "0055842", cli1, cid2);
		
		// RELACIONANDO CLIENTE-ENDEREÇO
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
	}

}
