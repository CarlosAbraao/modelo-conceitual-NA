package com.carlosdev.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.carlosdev.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	

	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date datapagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		// TODO Auto-generated constructor stub
		
		this.dataVencimento = dataVencimento;
		this.datapagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}

	
	
	

}
