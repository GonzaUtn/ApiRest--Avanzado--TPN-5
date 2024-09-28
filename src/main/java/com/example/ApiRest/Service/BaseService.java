package com.example.ApiRest.Service;
import com.example.ApiRest.Entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/*Recibe cualquier entidad y puede aplicar los metodos que se indican*/
public interface BaseService<E extends Base, ID extends Serializable> {
        public List<E> findAll() throws Exception; //Lista de todas las entidades
        public Page<E> findAll(Pageable pageable) throws Exception;
        public E findById(ID id) throws Exception; //Trae una entidad en funcion de su Id
        public E save (E entity) throws Exception; //Guarda una entidad en funcion de su Id
        public E update(ID id, E entity) throws Exception; //Actualiza la entidad en funcion de su Id
        public boolean delete (ID id) throws Exception; //Elimina el registro segun su Id



}
