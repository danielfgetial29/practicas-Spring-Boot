package com.interrapidisimo.sistema_logistico.model;

public class Conductor {
    //1. Completar la clase POJO de conductor con los atributos id, nombre, apellido, licencia, telefono y contraseña
    //2. Crear Interfaz ConductorService y su respectiva clase de implementacion
    //3. Crear clase controller para recibir solicitudes HTTP y hacer las respectivas pruebas con Postman o Insomnia

    //Atributos
    private String id;
    private String nombre;
    private String destino;
    private String licencia;
    private int telefono;
    private String contrasena;

    //Constructores
    //Vacio
    public Conductor(){}

    public Conductor(String id, String nombre, String destino, String licencia, int telefono, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.destino = destino;
        this.licencia = licencia;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }
}
