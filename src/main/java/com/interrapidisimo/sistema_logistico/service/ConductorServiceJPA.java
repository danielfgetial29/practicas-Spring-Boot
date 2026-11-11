package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ConductorServiceJPA implements ConductorService{

    private final ConductorRepository conductorRepository;

    @Autowired
    public ConductorServiceJPA(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    //Traer TODOS los conductores
    @Override
    public List<Conductor> findAll() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor findById(Long id) {
        return null;
    }

    //Guardar un conductor
    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor update(Long id, Conductor conductor) {
        return null;
    }

    @Override
    public Conductor updateContrasena(Long id, String nuevaContrasena) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Conductor> findByLicencia(String licencia) {
        return List.of();
    }
}
