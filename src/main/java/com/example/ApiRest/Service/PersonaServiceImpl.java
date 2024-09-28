package com.example.ApiRest.Service;

import com.example.ApiRest.Entities.Persona;
import com.example.ApiRest.Repository.BaseRepository;
import com.example.ApiRest.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;


    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
           //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro); //Query
            List<Persona> personas = personaRepository.search(filtro); //JPQL
            //List<Persona> personas = personaRepository.searchNativo(filtro); //QueryNativo

            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro); //Query
            Page<Persona> personas = personaRepository.search(filtro,pageable); //JPQL
            //List<Persona> personas = personaRepository.searchNativo(filtro); //QueryNativo

            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    }



