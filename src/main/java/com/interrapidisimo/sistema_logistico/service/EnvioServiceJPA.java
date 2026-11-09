package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Envio2;
import com.interrapidisimo.sistema_logistico.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnvioServiceJPA implements EnvioService2{

    // final porque no puede cambiar, siempre se envia el mismo
    private final EnvioRepository envioRepository;

    @Autowired // donde se hace la inyeccion de dependecias
    public EnvioServiceJPA(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<Envio2> findAll() {
        return List.of();
    }

    @Override
    public Envio2 findById(Long id) {
        return null;
    }

    //Guardar un envio
    @Override
    public Envio2 save(Envio2 envio) {

        double costo = calcularCostoEnvio(envio.getPesoKg(), envio.getDestino());
        envio.setCosto(costo);

        if (envio.getEstado() == null) {
            envio.setEstado("PENDIENTE");
        }
        if (envio.getPesoKg() > 500){
            throw new RuntimeException("El envío no debe pesar más de 500 kg");
        }

        return envioRepository.save(envio);
    }

    @Override
    public Envio2 update(Long id, Envio2 envio) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Envio2> findByEstado(String estado) {
        return List.of();
    }

    // Metodos de logica de negocio

    //Para calcular el costo del envio
    private  double calcularCostoEnvio(double pesoKg, String destino){
        double costoBase = 10000;

        if (pesoKg > 50) costoBase *= 1.2;
        if ("Internacional".equalsIgnoreCase(destino)) costoBase *= 1.5;
        return costoBase;
    }
}
