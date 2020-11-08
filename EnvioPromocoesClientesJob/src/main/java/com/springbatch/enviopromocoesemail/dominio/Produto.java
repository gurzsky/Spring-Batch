package com.springbatch.enviopromocoesemail.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

	private int id;
	private String nome;
	private String descricao;
	private Double preco;
}
