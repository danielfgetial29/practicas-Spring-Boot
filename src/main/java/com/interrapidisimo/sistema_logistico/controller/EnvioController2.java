package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.model.AsignacionEnvio;
import com.interrapidisimo.sistema_logistico.model.Envio2;
import com.interrapidisimo.sistema_logistico.service.EnvioService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController2 {

    private final EnvioService2 envioService;

    @Autowired
    public EnvioController2(EnvioService2 envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio2> getAllEnvios(){
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public Envio2 getEnvioById(@PathVariable Long id){
        return envioService.findById(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Envio2> getEnviosByEstado(@PathVariable String estado){
        return envioService.findByEstado(estado);
    }

    @PostMapping
    public Envio2 createEnvio(@RequestBody Envio2 envio){
        return envioService.save(envio);
    }

    @PutMapping("/{id}")
    public Envio2 updateEnvio(@PathVariable Long id, @RequestBody Envio2 envio){
        return envioService.update(id,envio);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id){
        envioService.deleteById(id);
    }

    @PostMapping("/{envioId}/asignar")
    public AsignacionEnvio asignarConductor(
            @PathVariable Long envioId,
            @RequestParam Long conductorId,
            @RequestParam String responsable,
            @RequestParam(required = false) String observaciones) {

        return envioService.asignarConductorAEnvio(
                envioId,
                conductorId,
                responsable,
                observaciones
        );
    }

}
