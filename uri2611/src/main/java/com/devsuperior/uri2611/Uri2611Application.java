package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.projections.MinMovieProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n#### NATIVE QUERY ####\n");
		List<MinMovieProjection> list = repository.searchNativeName("Action");
		List<MovieDTO> listDTONativeQuery = list.stream().map(e -> new MovieDTO(e))
				.collect(Collectors.toList());
		listDTONativeQuery.forEach(e -> System.out.println(e.getName()));


		System.out.println("\n#### JPQL QUERY ####\n");
		List<MovieDTO> listDTOJpqlQuery = repository.searchJPQL("action"); 
		listDTOJpqlQuery.forEach(e -> System.out.println(e.getName()));
	}
}
