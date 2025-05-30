package com.tarot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lectura {
    private final String tipoLectura;
    private final Date fecha;
    private final Persona persona;
    private final List<String> cartasSeleccionadas = new ArrayList<>();
    private String interpretacion = "";
    private final List<Prediccion> predicciones = new ArrayList<>();

    public Lectura(String tipoLectura, Persona persona) {
        if (tipoLectura == null || tipoLectura.trim().isEmpty())
            throw new IllegalArgumentException("Tipo de lectura no válido.");
        this.tipoLectura = tipoLectura;
        this.persona = persona;
        this.fecha = new Date();
    }

    public void agregarCarta(String carta) {
        cartasSeleccionadas.add(carta);
    }

    public void generarPredicciones(String categoria) {
        Prediccion p = new Prediccion("Predicción " + categoria, categoria, new Date(fecha.getTime() + 7L*24*3600*1000));
        p.generarPrediccion(cartasSeleccionadas, persona.getTarot());
        predicciones.add(p);
    }

    public void realizarLectura() {
        StringBuilder sb = new StringBuilder();
        sb.append("🔮 Lectura de Tarot (").append(tipoLectura).append(") para ").append(persona.getNombre()).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n\n");
        for (String c : cartasSeleccionadas) {
            sb.append("- ").append(c)
                    .append(": ").append(persona.getTarot().obtenerSignificadoCarta(c))
                    .append("\n");
        }
        sb.append("\n").append("Interpretación general:\n");
        sb.append(persona.getCartaAstral().generarInterpretacionGeneral());
        sb.append("\n\nPredicciones:\n");
        predicciones.forEach(pred -> sb.append(pred.getDescripcion()).append("\n\n"));
        interpretacion = sb.toString();
    }

    public String getInterpretacion() {
        return interpretacion;
    }
}