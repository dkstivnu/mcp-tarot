package com.tarot.model;

import java.util.Random;

public class Prediccion {

    private String descripcion;
    private String categoria;
    private String probabilidad;

    public Prediccion(String categoria) {

        this.categoria = categoria;
        this.probabilidad = "Media";
    }

    public void generarPrediccion(Tarot tarot) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("🔮 ***Predicción de Tarot para el área de ").append(categoria).append("*** 🔮\n");

        String[] sentidos = {"Al derecho", "Al revés", "Normal"};

        for (CartaAstral carta : tarot.getCartas()) {

            String sentido = sentidos[r.nextInt(sentidos.length)];

            String interpretacion = interpretarCarta(carta, categoria, sentido);

            sb.append("🃏 ***").append(carta).append("*** (").append(sentido).append("):\n");
            sb.append(interpretacion).append("\n\n");
        }
        sb.append("✨ Esta prediccion es una guía profunda sobre tu situación futura en el área de ").append(categoria.toLowerCase())
                .append(". Las cartas iluminan caminos posibles, pero la elección final siempre es tuya.\n");

        this.descripcion = sb.toString();
    }

    private String interpretarCarta(CartaAstral carta,
                                    String categoria,
                                    String sentido) {

        String general = carta.obtenerSignificadoGeneral();

        // 2) Según el sentido, obtengo el significado al derecho o al revés
        String especifico = "";
        if ("Al revés".equalsIgnoreCase(sentido)) {
            especifico = carta.obtenerSignificadoAlReves();
        } else if ("Al derecho".equalsIgnoreCase(sentido)) {
            // Por defecto lo mostramos al derecho
            especifico = carta.obtenerSignificadoAlDerecho();
        } else if ("Normal".equalsIgnoreCase(sentido)) {
            especifico = "";
        }

        // 3) Construyo un bloque con el área / categoría que me pasaron
        String area = carta.obtenerArea();

        // 4) Combino todo en un único texto
        return general + "\n" +
                especifico + "\n" +
                "Categoría: " + categoria +
                "Área: " + area + "\n"+
                "Probabilidad: " + obtenerNivelProbabilidad(carta) + "\n";
    }

    public String obtenerNivelProbabilidad(CartaAstral carta) {
        if (carta instanceof ArcanoMenor) {
            // Para cartas menores: su propio mensaje
            this.probabilidad = ((ArcanoMenor) carta).obtenerMensajeProbabilidad();
        } else {
            // Para cartas mayores: probabilidad base ±10%
            Random r = new Random();
            int prob = r.nextInt(100);
            this.probabilidad = "La probabilidad es: "+ prob + "%\n";
        }
        return "Ninguna";
    }

    public void setProbabilidad(int probabilidad) throws ProbabilidadInvalidaException {
        if (probabilidad < 0 || probabilidad > 100) {
            throw new ProbabilidadInvalidaException("La probabilidad debe estar entre 0 y 100.");
        }
        this.probabilidad = "La probabilidad es: " + probabilidad;
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

    public String getProbabilidad() {
        return probabilidad;
    }

}
