package com.interrapidisimo.sistema_logistico.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "conductores")
public class Conductor {
    //1. Completar la clase POJO de conductor con los atributos id, nombre, apellido, licencia, telefono y contraseña
    //2. Crear Interfaz ConductorService y su respectiva clase de implementacion
    //3. Crear clase controller para recibir solicitudes HTTP y hacer las respectivas pruebas con Postman o Insomnia


    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true ,nullable = false)
    private String licencia;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false)
    private String contrasena;

    //Relacion mapeada
    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AsignacionEnvio> asignaciones = new ArrayList<>();

    //Constructores

    //Vacio
    public Conductor(){}

    //Con parametros
    public Conductor(String nombre, String apellido, String licencia, int telefono, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.telefono = telefono;
        this.contrasena = contrasena;

    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<AsignacionEnvio> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignacionEnvio> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
