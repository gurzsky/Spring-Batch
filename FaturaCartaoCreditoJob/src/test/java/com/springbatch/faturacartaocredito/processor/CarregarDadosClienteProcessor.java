package com.springbatch.faturacartaocredito.processor;

import javax.xml.bind.ValidationException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springbatch.faturacartaocredito.dominio.Cliente;
import com.springbatch.faturacartaocredito.dominio.FaturaCartaoCredito;

public class CarregarDadosClienteProcessor implements ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito>{
	
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public FaturaCartaoCredito process(FaturaCartaoCredito faturaCartaoCredito) throws Exception {
		
		String uri = String.format("http://my-json-server.typicode.com/giuliana-bezera/demo/profile/%d", faturaCartaoCredito.getCliente().getId());
		ResponseEntity<Cliente> response = restTemplate.getForEntity(uri, Cliente.class);
		
		if (response.getStatusCode() != HttpStatus.OK)
			throw new ValidationException("Cliente não encontrado!");
		
		faturaCartaoCredito.setCliente(response.getBody());
		return faturaCartaoCredito;
	}
}
