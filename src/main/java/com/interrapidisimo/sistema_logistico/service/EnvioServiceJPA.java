package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Envio2;
import com.interrapidisimo.sistema_logistico.repository.EnvioRepository;
import jakarta.transaction.Transactional;
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
        return envioRepository.findAll();
    }

    @Override
    public Envio2 findById(Long id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con Id "+ id));
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
    @Transactional
    public Envio2 update(Long id, Envio2 envioActualizado) {
        Envio2 existente = envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado con id "+ id));

        if ("Entregado".equalsIgnoreCase(existente.getEstado())){
            throw new RuntimeException("No se puede actualizar un envio que ya fue entregado");
        }

        if (envioActualizado.getEstado() != null && !envioActualizado.getEstado().equalsIgnoreCase(existente.getEstado())){
            validarTRansaccionEstado(existente.getEstado(), envioActualizado.getEstado());
        }

        if (cambiarPesoODestino(existente, envioActualizado)){
            double nuevoCosto = calcularCostoEnvio(envioActualizado.getPesoKg(), envioActualizado.getDestino());
            envioActualizado.setCosto(nuevoCosto);
        }
        envioActualizado.setId(id);
        return envioRepository.save(envioActualizado);
    }

    @Override
    public void deleteById(Long id) {
        if (!envioRepository.existsById(id)){
            throw new RuntimeException("Envio no encontrado con Id "+ id);
        }
        envioRepository.deleteById(id);

    }

    @Override
    public List<Envio2> findByEstado(String estado) {
        return envioRepository.findByEstado(estado);
    }

    // Metodos de logica de negocio

    //Para calcular el costo del envio
    private  double calcularCostoEnvio(double pesoKg, String destino){
        double costoBase = 10000;

        if (pesoKg > 50) costoBase *= 1.2;
        if ("Internacional".equalsIgnoreCase(destino)) costoBase *= 1.5;
        return costoBase;
    }

    private void validarTRansaccionEstado(String actual, String nuevo){
        boolean permitida = switch (actual){
            case "Pendiente" -> nuevo.equalsIgnoreCase("En_ruta") || nuevo.equalsIgnoreCase("Cancelado");
            case "En_ruta" -> nuevo.equalsIgnoreCase("Entregado");
            default -> false;
        };
        if (!permitida){
            throw new RuntimeException("No se puede cambiar de '"+ actual + "'a' "+ nuevo + "'");
        }
    }

    private boolean cambiarPesoODestino(Envio2 existente, Envio2 envioactualizado){
        return existente.getPesoKg() != envioactualizado.getPesoKg()
                || existente.getDestino().equalsIgnoreCase(envioactualizado.getDestino());
    }
}
