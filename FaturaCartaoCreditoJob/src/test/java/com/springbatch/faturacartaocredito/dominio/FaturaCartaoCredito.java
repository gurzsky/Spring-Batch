package com.springbatch.faturacartaocredito.dominio;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaturaCartaoCredito {
	
	private Cliente cliente;
	private CartaoCredito cartaoCredito;
	private List<Transacao> transacoes = new ArrayList<>();

}
