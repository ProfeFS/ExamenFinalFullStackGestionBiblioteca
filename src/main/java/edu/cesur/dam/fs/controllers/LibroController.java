package edu.cesur.dam.fs.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import edu.cesur.dam.fs.model.LibroDTO;
import edu.cesur.dam.fs.services.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	LibroService libroService;
	
	@PostMapping
	ResponseEntity<?> createLibro(@RequestBody LibroDTO libroDTO){
		
		LibroDTO libro = libroService.createBook(libroDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + libro.getId())
				.buildAndExpand(libro.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	
	@GetMapping
	ResponseEntity<?> getLibros(){
		
		List<LibroDTO> libros = libroService.getBooks();
		if(libros.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		return ResponseEntity.ok(libros);
		
	}

}
