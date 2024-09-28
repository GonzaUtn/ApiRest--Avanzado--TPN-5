package com.example.ApiRest.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@SuperBuilder
public class Persona extends Base{
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;


    @OneToMany (cascade = {CascadeType.ALL, CascadeType.MERGE},orphanRemoval = true)
    @Builder.Default
    private List<Libro> libros = new ArrayList<Libro>();
    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }






}
