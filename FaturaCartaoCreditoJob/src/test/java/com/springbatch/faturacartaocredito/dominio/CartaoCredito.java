package com.springbatch.faturacartaocredito.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoCredito {
	
	private int numeroCartaoCredito;
	private Cliente cliente;
}
