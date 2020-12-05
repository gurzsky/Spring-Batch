package com.springbatch.projetopessoal.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class ConfigJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job configJob(
			@Qualifier("pessoasStep") Step pessoasStep) {		
		return jobBuilderFactory
				.get("configJob")
				.start(pessoasStep)
				.incrementer(new RunIdIncrementer())
				.build();		
	}

}
