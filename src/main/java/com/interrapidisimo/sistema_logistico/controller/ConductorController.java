package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    @Autowired
    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    //Traer TODOS los conductores
    @GetMapping
    public List<Conductor> getAllConductores(){
        return conductorService.findAll();
    }
}
