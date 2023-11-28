package edu.cesur.dam.fs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.dam.fs.mappers.AutorMapper;
import edu.cesur.dam.fs.model.AutorDTO;
import edu.cesur.dam.fs.persistence.repositories.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	AutorRepository autorRepository;
	@Autowired
	AutorMapper autorMapper;

	@Override
	public AutorDTO createAuthor(AutorDTO autorDTO) {

		return autorMapper.toDTO(autorRepository.save(autorMapper.toEntity(autorDTO)));
	}

	@Override
	public List<AutorDTO> getAuthors() {
		
		return autorMapper.toDTOList(autorRepository.findAll());
	}

}
