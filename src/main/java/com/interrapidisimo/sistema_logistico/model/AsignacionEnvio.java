package com.interrapidisimo.sistema_logistico.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asignacion_envio")
public class AsignacionEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Envio2 envio;

    private  Conductor conductor;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion;

    @Column(nullable = false)
    private String responsable;

    @Column(length = 500)
    private String observaciones;

}
