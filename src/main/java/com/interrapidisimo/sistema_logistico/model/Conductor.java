package com.interrapidisimo.sistema_logistico.model;

import jakarta.persistence.*;


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
    private String nombre;
    private String apellido;
    private String licencia;
    private int telefono;
    private String contrasena;

    //Constructores
    //Vacio
    public Conductor(){}

    public Conductor(Long id, String nombre, String apellido, String licencia, int telefono, String contrasena) {
        this.id = id;
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

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
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
}
