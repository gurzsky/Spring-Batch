package com.springbatch.migracaodados.dominio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
	
	private int id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private int idade;
}
