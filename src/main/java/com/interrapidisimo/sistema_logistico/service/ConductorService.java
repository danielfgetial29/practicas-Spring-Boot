package com.interrapidisimo.sistema_logistico.service;

import com.interrapidisimo.sistema_logistico.model.Conductor;


import java.util.List;

public interface ConductorService {

    //Comportamientos

    //Encontrar todos los conductores
    List<Conductor> findAll();

    //Encontar un conductor por su id
    Conductor findById(String id);

    //Guardar un conductor nuevo
    Conductor save(Conductor conductor);

    //Actualizar todos los datos de un conductor
    Conductor update(String id, Conductor conductor);

    //Actualizar solo un dato del conductor (su contraseña)
    Conductor updateContrasena(String id, String nuevaContrasena);

    //Eliminar
    void deleteById(String id);

    //Buscar por tipo de licencia
    List<Conductor> findByLicencia(String licencia);


}
