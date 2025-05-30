package com.tarot.model;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Prediccion {
    private final String titulo;
    private final String categoria;
    private final Date fechaPrediccion;
    private final Date fechaVencimiento;
    private int probabilidad = 50;
    private String descripcion = "";

    public Prediccion(String titulo, String categoria, Date fechaVencimiento) {
        if (titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("Título no válido.");
        if (categoria == null || categoria.trim().isEmpty())
            throw new IllegalArgumentException("Categoría no válida.");
        if (fechaVencimiento == null)
            throw new IllegalArgumentException("Vencimiento obligatorio.");
        this.titulo = titulo;
        this.categoria = categoria;
        this.fechaPrediccion = new Date();
        this.fechaVencimiento = fechaVencimiento;
    }

    public void generarPrediccion(List<String> cartasSeleccionadas, Tarot tarot) {
        StringBuilder sb = new StringBuilder();
        sb.append("✨ ").append(titulo).append(" (").append(categoria).append(")\n");
        for (String c : cartasSeleccionadas) {
            String sentido = new String[]{"Al derecho","Al revés","Boca abajo"}[new Random().nextInt(3)];
            String base = tarot.obtenerSignificadoCarta(c);
            sb.append("- ").append(c).append(" [").append(sentido).append("]: ").append(base).append("\n");
        }
        this.descripcion = sb.toString();
    }

    public String getDescripcion() {
        return descripcion;
    }
}