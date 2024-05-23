package com.proyectofarmaciaBD2.services.implementations;

import com.proyectofarmaciaBD2.dtos.request.Domicilio.DomicilioDTORequest;
import com.proyectofarmaciaBD2.entities.Domicilio;
import com.proyectofarmaciaBD2.repositories.DomicilioRepository;
import com.proyectofarmaciaBD2.services.IDomicilioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("domicilioService")
public class DomicilioService implements IDomicilioService {

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @Autowired
    private DomicilioRepository domicilioRepository;

    public boolean crearDomicilio(DomicilioDTORequest dto) throws Exception {

        Optional<Domicilio> domicilioOptional = domicilioRepository.findByCalleAndNumeroAndLocalidadAndProvincia(dto.getCalle(), dto.getNumero(), dto.getLocalidad(), dto.getProvincia());
        Domicilio domicilio = new Domicilio();

        if(domicilioOptional.isPresent()){
            domicilio = domicilioOptional.get();
        }else {
            domicilio = modelMapper.map(dto, domicilio.getClass());
        }
        domicilioRepository.save(domicilio);
        return true;
    }
}
