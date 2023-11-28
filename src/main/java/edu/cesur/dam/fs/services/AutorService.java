package edu.cesur.dam.fs.services;

import java.util.List;

import edu.cesur.dam.fs.model.AutorDTO;

public interface AutorService {
	
	AutorDTO createAuthor(AutorDTO autorDTO);
	
	List<AutorDTO> getAuthors();

}
