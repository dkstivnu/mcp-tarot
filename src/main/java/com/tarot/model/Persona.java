package com.tarot.model;

import java.util.Date;

public class Persona {

    // Atributos

    private String nombre;
    private Date fechaNacimiento;
    private Zodiaco signoZodiaco;
    private Tarot tarot;


    // Constructores

    public Persona(Date fechaNacimiento, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.signoZodiaco = leerSigno(fechaNacimiento);
        this.tarot = new Tarot();
    }

    public Persona() {
        this.nombre = "N/A";
        this.fechaNacimiento = new Date();
        this.signoZodiaco = null;
        this.tarot = new Tarot();

    }

    // Metodos getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Zodiaco getSignoZodiaco() {
        return signoZodiaco;
    }

    public void setSignoZodiaco(Zodiaco signoZodiaco) {
        this.signoZodiaco = signoZodiaco;
    }

    public Tarot getTarot() {
        return tarot;
    }

    public void setTarot(Tarot tarot) {
        this.tarot = tarot;
    }


    // Metodos propios

    private Zodiaco leerSigno(Date fechaNacimiento) {
        throw (new RuntimeException("Implementar la lectura del signo a partir de la fecha"));
    }
}
