package com.springbatch.projetopessoal.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.springbatch.projetopessoal.dominio.Pessoa;

public class ConfigStep {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step pessoasStep(
			ItemReader<Pessoa> lerPessoas,
			ItemProcessor<Pessoa, Pessoa> processarPessoas,
			ItemWriter<Pessoa> escreverPessoa) {
		
		return stepBuilderFactory
				.get("pessoasStep")
				.<Pessoa, Pessoa>chunk(1)
				.reader(lerPessoas)
				.processor(processarPessoas)
				.writer(escreverPessoa)
				.build();
	}
}
