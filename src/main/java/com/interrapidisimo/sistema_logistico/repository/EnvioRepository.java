package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.Envio2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio2, Long> {

    //PREFIJO + PROPIEDAD + PALABRA CLAVE

    List<Envio2> findByEstado(String estado);
    List<Envio2> findByCliente(String cliente);
    List<Envio2> finbyClienteAndEstado(String cliente, String estado);
}
