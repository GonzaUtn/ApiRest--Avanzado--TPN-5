package com.example.ApiRest.Controller;

import com.example.ApiRest.Entities.Domicilio;

import com.example.ApiRest.Service.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*") // Permite o no a la API desde distintos origenes
@RequestMapping(path = "ApiRest/v1/domicilios")

public class DomicilioController extends BaseControllerImpl<Domicilio , DomicilioServiceImpl> {

}
