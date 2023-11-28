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

import edu.cesur.dam.fs.model.AutorDTO;
import edu.cesur.dam.fs.model.LibroDTO;
import edu.cesur.dam.fs.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorRestController {
	
	@Autowired
	AutorService autorService;
	
	@PostMapping
	ResponseEntity<?> createAuthor(@RequestBody AutorDTO autorDTO){
		
		AutorDTO autor = autorService.createAuthor(autorDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + autor.getId())
				.buildAndExpand(autor.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping
	ResponseEntity<?> getAuthors(){
		
		List<AutorDTO> autores = autorService.getAuthors();
		if(autores.isEmpty()) {
			return ResponseEntity.noContent().build();			
		}
		
		return ResponseEntity.ok(autores);
		
	}

}
