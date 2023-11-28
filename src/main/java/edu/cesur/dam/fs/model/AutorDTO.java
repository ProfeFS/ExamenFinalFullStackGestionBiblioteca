package edu.cesur.dam.fs.model;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {

    private Long id;
    private String nombre;
    private String nacionalidad;
    private List<LibroDTO> libros = new ArrayList<>();

   
}