package com.proyectofarmaciaBD2.repositories;

import com.proyectofarmaciaBD2.entities.Domicilio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomicilioRepository extends MongoRepository <Domicilio, Integer> {

    Domicilio findById(long id);

    Optional<Domicilio> findByCalleAndNumeroAndLocalidadAndProvincia(String calle, int numero, String localidad, String provincia);

}
