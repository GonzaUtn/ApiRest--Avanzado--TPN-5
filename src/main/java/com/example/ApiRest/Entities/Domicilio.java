package com.example.ApiRest.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@SuperBuilder
public class Domicilio extends Base{
    @Column(name = "Calle")
    private String calle;
    @Column(name = "Numero")
    private int numero;


    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

/*
    @OneToMany(mappedBy = "domicilio", cascade = CascadeType.ALL)
    private List<Localidad> localidad= new ArrayList<Localidad>();

 */


}
