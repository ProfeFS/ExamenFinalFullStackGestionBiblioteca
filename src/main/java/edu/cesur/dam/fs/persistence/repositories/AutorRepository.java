package edu.cesur.dam.fs.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cesur.dam.fs.persistence.entities.AutorEntity;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long>{	
	
	List<AutorEntity> findByNombre(String nombre);

}
