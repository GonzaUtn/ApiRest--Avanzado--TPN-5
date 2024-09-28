package com.example.ApiRest.Controller;

import com.example.ApiRest.Entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable> {
    // El ? es un comodin que no indica que el objeto que le pasamos extiende de la clase Object
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update( @PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete (@PathVariable ID id);

}
