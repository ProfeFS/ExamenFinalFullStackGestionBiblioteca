package edu.cesur.dam.fs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.dam.fs.mappers.LibroMapper;
import edu.cesur.dam.fs.model.LibroDTO;
import edu.cesur.dam.fs.persistence.entities.AutorEntity;
import edu.cesur.dam.fs.persistence.entities.LibroEntity;
import edu.cesur.dam.fs.persistence.repositories.AutorRepository;
import edu.cesur.dam.fs.persistence.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroRepository libroRepository;

	@Autowired
	LibroMapper libroMapper;

	@Autowired
	AutorRepository autorRepository;

	@Override
	public LibroDTO createBook(LibroDTO libroDTO) {
		
		AutorEntity autor = autorRepository.findById(libroDTO.getAutorId())
				.orElseThrow(()-> new RuntimeException("El autor del libro no existe en la BDD"));		
		
		LibroEntity libroE = libroMapper.toEntity(libroDTO);
		libroE.setAutor(autor);
		
		return libroMapper.toDTO(libroRepository.save(libroE));
	}

	@Override
	public List<LibroDTO> getBooks() {
		
		List<LibroEntity> libros = libroRepository.findAll(); 
		
		return libroMapper.toDTOList(libros);
	}

}
