package com.carlosdev;

import java.text.SimpleDateFormat;
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
import com.carlosdev.domain.ItemPedido;
import com.carlosdev.domain.Pagamento;
import com.carlosdev.domain.PagamentoComCartao;
import com.carlosdev.domain.Pedido;
import com.carlosdev.domain.Produto;
import com.carlosdev.domain.enums.EstadoPagamento;
import com.carlosdev.domain.enums.TipoCliente;
import com.carlosdev.repository.CategoriaRepository;
import com.carlosdev.repository.CidadeRepository;
import com.carlosdev.repository.ClienteRepository;
import com.carlosdev.repository.EnderecoRepository;
import com.carlosdev.repository.EstadoRepository;
import com.carlosdev.repository.ItemPedidoRepository;
import com.carlosdev.repository.PagamentoRepository;
import com.carlosdev.repository.PedidoRepository;
import com.carlosdev.repository.ProdutoRepository;
import com.carlosdev.service.DBService;

@SpringBootApplication
public class MdconceitualApplication implements CommandLineRunner {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MdconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
			
		
	}

}
