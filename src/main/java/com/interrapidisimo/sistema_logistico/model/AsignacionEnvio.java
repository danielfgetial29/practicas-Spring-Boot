package com.interrapidisimo.sistema_logistico.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asignacion_envio")
public class AsignacionEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //RElacion de muchos a uno
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_id", nullable = false)
    private Envio2 envio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id", nullable = false)
    private  Conductor conductor;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion;

    @Column(nullable = false)
    private String responsable;

    @Column(length = 500)
    private String observaciones;

    //Constructores


}
