package com.springbatch.projetopessoal.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.projetopessoal.dominio.Pessoa;
import com.springbatch.projetopessoal.dominio.PessoaSaida;

@Configuration
public class ConfigStep {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step pessoasStep(
			ItemReader<Pessoa> lerPessoas,
			ItemProcessor<Pessoa, PessoaSaida> processPessoasConfig,
			ItemWriter<PessoaSaida> writerPessoa) {
		
		return stepBuilderFactory
				.get("pessoasStep")
				.<Pessoa, PessoaSaida>chunk(100)
				.reader(lerPessoas)
				.processor(processPessoasConfig)
				.writer(writerPessoa)
				.build();
	}
}
