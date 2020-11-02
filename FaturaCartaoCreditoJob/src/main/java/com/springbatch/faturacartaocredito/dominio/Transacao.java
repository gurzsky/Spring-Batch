package com.springbatch.faturacartaocredito.dominio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transacao {
	
	private int id;
	private CartaoCredito cartaoCredito;
	private String descricao;
	private Double valor;
	private Date data;
}
