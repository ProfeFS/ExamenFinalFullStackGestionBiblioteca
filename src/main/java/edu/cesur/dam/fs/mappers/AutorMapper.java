package edu.cesur.dam.fs.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cesur.dam.fs.model.AutorDTO;
import edu.cesur.dam.fs.model.LibroDTO;
import edu.cesur.dam.fs.persistence.entities.AutorEntity;
import edu.cesur.dam.fs.persistence.entities.LibroEntity;



@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface AutorMapper {
	
	AutorDTO toDTO(AutorEntity autorEntity);
	
	AutorEntity toEntity(AutorDTO autorDTO);
	
	List<AutorDTO> toDTOList(List<AutorEntity> autores);

}
