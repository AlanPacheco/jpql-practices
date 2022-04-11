package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dto.MovieDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MinMovieProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(nativeQuery = true, value = "SELECT m.name "
									+ "FROM genres g INNER JOIN movies m "
									+ "	ON(g.id = m.id_genres) "
									+ "WHERE UPPER(g.description) = UPPER(:genre)")
	public List<MinMovieProjection> searchNativeName(String genre);
	
	@Query(value = "SELECT new com.devsuperior.uri2611.dto.MovieDTO(obj.name) "
			+ "FROM Movie obj INNER JOIN Genre gen "
			+ "ON(obj.genre = gen.id) "
			+ "WHERE UPPER(gen.description) = UPPER(:genre)")
	public List<MovieDTO> searchJPQL(String genre);
}
