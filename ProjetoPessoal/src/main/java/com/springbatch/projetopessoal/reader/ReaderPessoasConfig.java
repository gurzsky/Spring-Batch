package com.springbatch.projetopessoal.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.springbatch.projetopessoal.dominio.Pessoa;

public class ReaderPessoasConfig {
	
	@Bean
	public JdbcCursorItemReader<Pessoa> lerPessoas(
			@Qualifier("appDataSource") DataSource dataSource) {
		
		return new JdbcCursorItemReaderBuilder()
				.name("lerPessoas")
				.dataSource(dataSource)
				.sql("")
				.build();
	}

}
