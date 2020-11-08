package com.springbatch.enviopromocoesemail.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InteresseProdutoCliente {

	private Cliente cliente;
	private Produto produto;
}
