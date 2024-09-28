package com.example.ApiRest.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Libro")
@Getter
@Setter

@AllArgsConstructor
@Audited
@SuperBuilder
public class Libro extends Base {

    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Fecha")
    private int fecha;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Paginas")
    private int paginas;
    @Column(name = "Autor")
    private String autor;


    @ManyToMany(mappedBy = "libros")
    @Builder.Default
    private List<Autor> autores = new ArrayList<Autor>();




}
