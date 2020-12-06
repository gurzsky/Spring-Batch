package com.springbatch.projetopessoal.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.springbatch.projetopessoal.dominio.PessoaSaida;

@Configuration
public class WriterPessoaConfig {
	
	@Bean
	public FlatFileItemWriter<PessoaSaida> writerPessoa() {
		
		return new FlatFileItemWriterBuilder<PessoaSaida>()
				.name("writerPessoaConfig")
				.resource(new FileSystemResource("files/pessoas.csv"))
				.build();
	}

}
