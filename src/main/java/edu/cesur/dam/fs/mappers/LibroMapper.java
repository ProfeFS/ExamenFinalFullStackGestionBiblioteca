package edu.cesur.dam.fs.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import edu.cesur.dam.fs.model.LibroDTO;
import edu.cesur.dam.fs.persistence.entities.AutorEntity;
import edu.cesur.dam.fs.persistence.entities.LibroEntity;

@Mapper(componentModel = "spring")
public interface LibroMapper {

	@Mapping(source = "autor", target = "autorId", qualifiedByName = "mapAutorId")
	LibroDTO toDTO(LibroEntity libroEntity);

	LibroEntity toEntity(LibroDTO libroDTO);
	
	List<LibroDTO> toDTOList(List<LibroEntity> librosEntity);

	@Named("mapAutorId")
	default Long mapNombreAutor(AutorEntity autor) {
		if (autor != null) {
			return autor.getId();
		} else {
			return null;
		}

	}

}
