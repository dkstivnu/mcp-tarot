package com.tarot.model;

import java.util.Random;

public class Prediccion {

    private String descripcion;
    private String categoria;
    private int probabilidad;

    public Prediccion(String categoria) {
        this.categoria = categoria;
        this.probabilidad = 50;
    }

    public void generarPrediccion(Tarot tarot) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("🔮 ***Predicción de Tarot para el área de ").append(categoria).append("*** 🔮\n");

        String[] sentidos = {"Al derecho", "Al revés", "Normal"};

        for (CartaAstral carta : tarot.getCartas()) {

            String sentido = sentidos[r.nextInt(sentidos.length)];

            String interpretacion = interpretarCarta(sentido, categoria, carta);

            sb.append("🃏 ***").append(carta).append("*** (").append(sentido).append("):\n");
            sb.append(interpretacion).append("\n\n");
        }
        sb.append("✨ Esta prediccion es una guía profunda sobre tu situación futura en el área de ").append(categoria.toLowerCase())
                .append(". Las cartas iluminan caminos posibles, pero la elección final siempre es tuya.\n");

        this.descripcion = sb.toString();
    }

    private String interpretarCarta(String sentido, String categoria, CartaAstral carta) {
        StringBuilder interpretacion = new StringBuilder();

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

    public int getProbabilidad() {
        return probabilidad;
    }

}
