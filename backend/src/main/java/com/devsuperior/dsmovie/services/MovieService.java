package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	@Transactional(readOnly = true) // Aqui fala que é so um mode de leitura com isso fica mais eficiente no banco de dados
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = repo.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;	
	}
	
	@Transactional(readOnly = true) // Aqui fala que é so um mode de leitura com isso fica mais eficiente no banco de dados
	public MovieDTO findById(Long id){
		Movie result = repo.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;	
	}
}