package edu.cesur.dam.fs.services;


import java.util.List;

import edu.cesur.dam.fs.model.LibroDTO;

public interface LibroService {
	
	LibroDTO createBook(LibroDTO libroDTO);
	
	List<LibroDTO> getBooks();

}
