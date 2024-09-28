package com.example.ApiRest.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ApiRest.Entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Esta interface es un patron permite separar la logica del negocio con el repository*/
@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

/*
    //Anotacion metodo query

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existByDni(int dni); // Verficacion con Booleano






    @Query(value = "SELECT p FROM Persona WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE 'filtro%'")
    List<Persona> search(String filtro);
/*
    @Query(value = "SELECT p FROM Persona WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE 'filtro%'")
    Page<Persona> search (String filtro , Pageable pageable);

 */
//Anotacion JPQL con parametro indexados
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')")
    List<Persona> search(@Param("filtro") String filtro);

    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);



    /*

    @Query(value="SELECT * FROM Persona WHERE Persona.nombre LIKE %filtro% OR Persona.apellido LIKE %filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro );

     */
/*
    @Query(value="SELECT * FROM Persona WHERE Persona.nombre LIKE %filtro% OR Persona.apellido LIKE %filtro%",
            countQuery = "SELECT count(*) FROM Persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro , Pageable pageable);

 */

}
