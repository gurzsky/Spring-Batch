package com.springbatch.projetopessoal.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springbatch.projetopessoal.dominio.Pessoa;
import com.springbatch.projetopessoal.dominio.PessoaSaida;

@Component
public class ProcessPessoasConfig implements ItemProcessor<Pessoa, PessoaSaida>{

	@Override
	public PessoaSaida process(Pessoa pessoa) throws Exception {
	
		PessoaSaida ps = new PessoaSaida();
		if (pessoa.getIdade() <= 25)
			ps.setDescricao("Primeira idade");
		else if (pessoa.getIdade() > 25 && pessoa.getIdade() <= 64)
			ps.setDescricao("Segunda idade");
		else 
			ps.setDescricao("Terceira idade");
		
		System.out.println(pessoa.getNome());
		
		return ps;
	}
}
