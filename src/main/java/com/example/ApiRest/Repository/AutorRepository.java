package com.example.ApiRest.Repository;

import com.example.ApiRest.Entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long>{
}
