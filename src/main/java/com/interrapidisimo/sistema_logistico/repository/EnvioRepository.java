package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.Envio2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnvioRepository extends JpaRepository<Envio2, Long> {

    //PREFIJO + PROPIEDAD + PALABRA CLAVE

    List<Envio2> findByEstado(String Estado);
}
