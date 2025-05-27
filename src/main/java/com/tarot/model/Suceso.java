package com.tarot.model;

import java.util.Date;

public class Suceso {
    private String nombre;
    private String descripcion;
    private Date fechaOcurrencia;
    private String tipo;       // por ejemplo: “Amor”, “Trabajo”, “Salud”
    private String areaVida;   // categorización más fina, darle profundidad 
    private int impacto;       // 1..10
    private boolean confirmado;

    public Suceso(String nombre, String descripcion, Date fechaOcurrencia,
                  String tipo, String areaVida, int impacto, boolean confirmado) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre del suceso no válido.");
        if (descripcion == null) descripcion = "";
        if (fechaOcurrencia == null)
            throw new IllegalArgumentException("Fecha de ocurrencia es obligatoria.");
        if (impacto < 1 || impacto > 10)
            throw new IllegalArgumentException("Impacto debe estar entre 1 y 10."); //Excepciones

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaOcurrencia = fechaOcurrencia;
        this.tipo = tipo;
        this.areaVida = areaVida;
        this.impacto = impacto;
        this.confirmado = confirmado; //Constructores
    }

    public String obtenerNivelImpacto() {
        if (impacto <= 3) return "Bajo";
        if (impacto <= 7) return "Medio";
        return "Alto";
    }

    public boolean esReciente() {
        long diff = new Date().getTime() - fechaOcurrencia.getTime();
        return diff < 30L * 24 * 3600 * 1000; // último mes
    }

    public void setImpacto(int impacto) {
        if (impacto < 1 || impacto > 10)
            throw new IllegalArgumentException("Impacto debe estar entre 1 y 10."); //Mas Excepciones
        this.impacto = impacto;
    }

    // Mas getter y setter si necesitamos
}
