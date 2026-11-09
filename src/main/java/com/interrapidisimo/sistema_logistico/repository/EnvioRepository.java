package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.Envio2;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnvioRepository extends JpaRepository<Envio2, Long> {

    //PREFIJO + PROPIEDAD + PALABRA CLAVE

}
