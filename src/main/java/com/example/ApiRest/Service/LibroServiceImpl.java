package com.example.ApiRest.Service;

import com.example.ApiRest.Entities.Libro;
import com.example.ApiRest.Repository.BaseRepository;
import com.example.ApiRest.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {

        super(baseRepository);
        this.libroRepository = libroRepository;
    }
}
