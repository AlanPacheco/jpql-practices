package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("\n\n---Consulta em NATIVE QUERY---");
		List<CustomerMinProjection> list = repository.searchNativeName("rs");
		List<CustomerNameDTO> customersNameDTO = list.stream().map(e -> new CustomerNameDTO(e)).collect(Collectors.toList());
		
		customersNameDTO.forEach(e -> System.out.println(e.getName())); 
		
//		JPQL
		System.out.printf("\n\n---Consulta em JPQL---");
		
		List<CustomerNameDTO> customersNameDTOJPQL = repository.searchJPQLName("rs");
		customersNameDTOJPQL.forEach(e -> System.out.println(e.getName()));
		
		
	}
}
