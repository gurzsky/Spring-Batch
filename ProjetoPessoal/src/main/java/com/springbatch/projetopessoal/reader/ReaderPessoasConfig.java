package com.springbatch.projetopessoal.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.springbatch.projetopessoal.dominio.Pessoa;

@Configuration
public class ReaderPessoasConfig {
	
	@Bean
	public JdbcCursorItemReader<Pessoa> lerPessoas(
			@Qualifier("appDataSource") DataSource dataSource) {
		
		return new JdbcCursorItemReaderBuilder<Pessoa>()
				.name("lerPessoas")
				.dataSource(dataSource)
				.sql("select * from pessoa")
				.rowMapper(new BeanPropertyRowMapper<Pessoa>(Pessoa.class))
				.build();
	}
}
