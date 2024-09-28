package com.example.ApiRest.Repository;

import com.example.ApiRest.Entities.Base;
import com.example.ApiRest.Entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {
}
