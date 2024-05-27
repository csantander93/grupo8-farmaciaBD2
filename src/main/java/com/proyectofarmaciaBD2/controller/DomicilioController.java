package com.proyectofarmaciaBD2.controller;

import com.proyectofarmaciaBD2.dtos.request.Domicilio.DomicilioDTORequest;
import com.proyectofarmaciaBD2.services.IDomicilioService;
import com.proyectofarmaciaBD2.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiDomicilio")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;

    @PostMapping("/crearDomicilio")
    public ResponseEntity<Object> crearDomicilio(@RequestBody DomicilioDTORequest dto){
        try{
            domicilioService.crearDomicilio(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Mensaje("Domicilio creado exitosamente"));
            //ES EQUIVALENTE
            //return new ResponseEntity<>(new Mensaje("Usuario creado exitosamente"), HttpStatus.CREATED );
        }catch(Exception e){
            return new ResponseEntity<>(new Mensaje(e.getMessage()) , HttpStatus.BAD_REQUEST);
            //ES EQUIVALENTE
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Mensaje(e.getMessage()));
        }
    }
}
