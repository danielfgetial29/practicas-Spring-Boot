package com.interrapidisimo.sistema_logistico.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "envios")
public class Envio2 {

    @Id // indica que es el id de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un id unico
    private Long id;

    @Column(nullable = false)// Hace que este campo no sea nullo
    private String cliente;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String estado;

    @Column(name = "peso_kg",nullable = false)
    private double pesoKg;

    @Column(nullable = false)
    private double costo;

    //Relaciones - Se debe dar el tipo de relacion que tendra con la otra tabla
    // Ya que sin indicar o mapear la relacion en Java no se podran llamar
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //(CascadeType) Para que no queden datos huerfanos
    private List<AsignacionEnvio> asignaciones = new ArrayList<>();

    //Constructores

    public Envio2(){}

    public Envio2(String cliente, String destino, String estado, double pesoKg, double costo) {
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
        this.costo = costo;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<AsignacionEnvio> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionEnvio> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
