package com.interrapidisimo.sistema_logistico.service;



import com.interrapidisimo.sistema_logistico.model.Envio2;

import java.util.List;

public interface EnvioService2 {
    List<Envio2> findAll();
    Envio2 findById(Long id);
    Envio2 save(Envio2 envio);
    Envio2 update(Long id, Envio2 envio);
    void deleteById(Long id);
    List<Envio2> findByEstado(String estado);
}
