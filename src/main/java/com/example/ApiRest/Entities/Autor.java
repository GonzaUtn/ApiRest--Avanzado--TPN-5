package com.example.ApiRest.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@SuperBuilder
public class Autor extends Base {

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Biografia", length = 1500)
    private String biografia;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "autor_libro" ,
               joinColumns = @JoinColumn(name= "autor_id"),
                inverseJoinColumns = @JoinColumn(name = "libro_id"))
    @Builder.Default
    private List<Libro> libros = new ArrayList<Libro>();

    public void addLibros (Libro libro){
        libros.add(libro);
        libro.getAutores().add(this);
    }

}
