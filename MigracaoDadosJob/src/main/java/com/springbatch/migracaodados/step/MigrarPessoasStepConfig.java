package com.springbatch.migracaodados.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class MigrarPessoasStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step migrarPessoasStep(
			ItemReader<Pessoa> arquivoPessoaReader,
			ItemWriter<Pessoa> bancoPessoaWriter
			) {
		return stepBuilderFactory
				.get("migrarPessoasStep")
				.<Pessoa, Pessoa> chunk(1)
				.reader(arquivoPessoaReader)
				.writer(bancoPessoaWriter)
				.build();				
	}
}
