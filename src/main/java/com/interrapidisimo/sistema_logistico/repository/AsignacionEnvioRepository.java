package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionEnvioRepository extends JpaRepository<AsignacionEnvio, Long> {

    List<AsignacionEnvio> findByEnvio_Id(Long envioId);
    List<AsignacionEnvio> findByConductor_Id(Long ConductorId);

}
