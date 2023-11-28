package edu.cesur.dam.fs.model;

import java.math.BigDecimal;

import edu.cesur.dam.fs.persistence.entities.AutorEntity;
import edu.cesur.dam.fs.persistence.entities.LibroEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private BigDecimal precio;
    private Long autorId;

 
}
