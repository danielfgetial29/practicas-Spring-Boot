package com.interrapidisimo.sistema_logistico.model;

public class Envio2 {

    private String id;
    private String cliente;
    private String destino;
    private String estado;
    private double pesoKg;

    public Envio2(){}

    public Envio2(String cliente, String destino, String estado, double pesoKg) {
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
    }

    //Getters y Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
