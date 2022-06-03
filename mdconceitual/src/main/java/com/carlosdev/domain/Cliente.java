package com.carlosdev.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.carlosdev.domain.enums.TipoCliente;

public class Cliente implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpfOuCnpj;
	// TIPO CLIENTE VAI RECEBER UM NUMERO INTEIRO
	private Integer tipoCliente;
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	// VOU CRIAR UMA LISTA DE TELEFONES COM A COLEÇÃO "SET" QUE N ACEITA REPETIÇÕES
	// ISSO PODERIA SER FEITO COM UMA CLASSE INDIVIDUAL
	
	private Set<String> telefones = new HashSet<>();
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String cpfOuCnpj, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		// TIPO CLIENTE VAI PASSAR O CODIGO
		this.tipoCliente = tipoCliente.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoCliente getTipoCliente() {
		// O TIPO CLIENTE TA PEGANDO O CODIGO E PASSANDO PARA O ENUM
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfOuCnpj, enderecos, id, nome, telefones, tipoCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefones, other.telefones) && tipoCliente == other.tipoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpfOuCnpj=" + cpfOuCnpj + ", tipoCliente=" + tipoCliente
				+ ", enderecos=" + enderecos + ", telefones=" + telefones + "]";
	}
	
	   
	

}
