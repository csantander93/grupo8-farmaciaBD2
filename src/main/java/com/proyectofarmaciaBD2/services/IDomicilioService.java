package com.proyectofarmaciaBD2.services;

import com.proyectofarmaciaBD2.dtos.request.Domicilio.DomicilioDTORequest;

public interface IDomicilioService {

    public boolean crearDomicilio(DomicilioDTORequest dto) throws Exception;
}
