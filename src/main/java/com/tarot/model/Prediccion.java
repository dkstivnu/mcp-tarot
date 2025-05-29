package com.tarot.model;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Prediccion {

    private String titulo;
    private String descripcion;
    private String categoria; 
    private Date fechaPrediccion;
    private Date fechaVencimiento;
    private int probabilidad; 
    private boolean cumplida;

    public Prediccion(String titulo, String categoria, Date fechaVencimiento) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.fechaPrediccion = new Date(); 
        this.fechaVencimiento = fechaVencimiento;
        this.probabilidad = 50; 
        this.cumplida = false;
    }

    public void generarPrediccion(List<String> cartasSeleccionadas, Tarot tarot) {
        StringBuilder sb = new StringBuilder();
        sb.append("🔮 ***Predicción de Tarot para el área de ").append(categoria).append("*** 🔮\n");
        sb.append("Fecha de la consulta: ").append(fechaPrediccion).append("\n\n");

        Random random = new Random();
        String[] sentidos = {"Al derecho", "Al revés", "Boca abajo", "Normal"};

        for (String carta : cartasSeleccionadas) {
            String sentido = sentidos[random.nextInt(sentidos.length)];
            String significadoBase = tarot.obtenerSignificadoCarta(carta);

            String interpretacion = interpretarCarta(significadoBase, sentido, categoria, carta);

            sb.append("🃏 ***").append(carta).append("*** (").append(sentido).append("):\n");
            sb.append(interpretacion).append("\n\n");
        }

        sb.append("✨ Esta lectura es una guía profunda sobre tu situación actual en el área de ").append(categoria.toLowerCase()).append(". Las cartas iluminan caminos posibles, pero la elección final siempre es tuya.\n");

        this.descripcion = sb.toString();
    }

    private String interpretarCarta(String significadoBase, String sentido, String categoria, String carta) {
        StringBuilder interpretacion = new StringBuilder();
        interpretacion.append(significadoBase);

        if (sentido.equals("Al revés")) {
            interpretacion.append(" Esta carta al revés indica bloqueos, resistencia o energías estancadas en el área de ").append(categoria.toLowerCase()).append(". Es probable que debas replantear decisiones o enfrentar obstáculos antes de avanzar.");
        } else if (sentido.equals("Boca abajo")) {
            interpretacion.append(" Al aparecer boca abajo, esta carta sugiere confusión, dudas o una interpretación distorsionada de la realidad. Podría haber percepciones erróneas o miedos ocultos que dificultan ver con claridad en temas de ").append(categoria.toLowerCase()).append(".");
        } else if (sentido.equals("Normal")) {
            interpretacion.append(" En posición normal, la carta mantiene un mensaje sutil, influyendo de forma indirecta o simbólica. No es una fuerza dominante, pero sí importante de considerar en tu vida actual.");
        } else {
            interpretacion.append(" Al derecho, esta carta manifiesta su energía plena y positiva. Es una señal alentadora para avanzar con confianza en el área de ").append(categoria.toLowerCase()).append(".");
        }

        interpretacion.append(" ").append(carta).append(" te invita a reflexionar profundamente sobre tu situación actual y a tomar decisiones conscientes para lograr equilibrio y bienestar.");

        return interpretacion.toString();
    }

    public boolean estaVencida() {
        return new Date().after(fechaVencimiento);
    }

    public String obtenerNivelProbabilidad() {
        if (probabilidad >= 80) return "Alta";
        else if (probabilidad >= 50) return "Media";
        else return "Baja";
    }

    public void setProbabilidad(int probabilidad) throws ProbabilidadInvalidaException {
        if (probabilidad < 0 || probabilidad > 100) {
            throw new ProbabilidadInvalidaException("La probabilidad debe estar entre 0 y 100.");
        }
        this.probabilidad = probabilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaPrediccion() {
        return fechaPrediccion;
    }

    public void setFechaPrediccion(Date fechaPrediccion) {
        this.fechaPrediccion = fechaPrediccion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public boolean isCumplida() {
        return cumplida;
    }

    public void setCumplida(boolean cumplida) {
        this.cumplida = cumplida;
    }
}
