package com.tarot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lectura de tarot.
 * Integra las cartas del Tarot de la Persona, mantiene predicciones
 * y construye una interpretación final con todas las cartas y predicciones.
 */
public class Lectura {
    /** Persona con su mazo de Tarot */
    private final Persona persona;
    /** Conjunto específico de cartas seleccionadas para esta lectura */
    private final List<CartaAstral> cartasSeleccionadas;
    /** Lista de predicciones generadas */
    private final List<Prediccion> predicciones;
    /** Interpretación final con lista de cartas y predicciones */
    private String interpretacionFinal;
    /** Fecha en que se realizó la lectura */
    private final LocalDate fecha;

    public Lectura(Persona persona, List<CartaAstral> cartasSeleccionadas) {
        this.persona = persona;
        // Se copian las cartas seleccionadas para evitar modificación externa
        this.cartasSeleccionadas = new ArrayList<>(cartasSeleccionadas);
        this.predicciones = new ArrayList<>();
        this.interpretacionFinal = "";
        this.fecha = LocalDate.now();
    }

    public void crearYAgregarPrediccion(Tarot tarot) {
        // Composición: la lectura crea instancias de Prediccion
        Prediccion pred = new Prediccion("General");
        pred.generarPrediccion(tarot);
        // Genera la descripción usando todo el mazo de la persona
        pred.generarPrediccion(persona.getTarot());
        predicciones.add(pred);
    }

    public void generarInterpretacionFinal() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Interpretación Final (" + fecha + ") ===\n\n");

        // 1. Incluir todas las cartas del Tarot de la persona
        sb.append("Cartas en el mazo:\n");
        for (CartaAstral carta : persona.getTarot().getCartas()) {
            sb.append("- ").append(carta.getNombre()).append("\n");
        }
        sb.append("\n");

        // 2. Incluir todas las predicciones específicas
        sb.append("Predicciones generadas:\n");

        for (Prediccion pred : predicciones) {
            pred.generarPrediccion(persona.getTarot());
            sb.append("- Carta: ")
                    .append(persona.getTarot().getCartas().get(1).getNombre())
                    .append(" -> ")
                    .append(pred.getDescripcion())
                    .append("\n");
        }

        // Almacena el resultado en el atributo principal
        interpretacionFinal = sb.toString();
    }

    // Getters para exponer la información de la lectura

    /** @return persona asociada a esta lectura */
    public Persona getPersona() {
        return persona;
    }

    /** @return cartas seleccionadas para la lectura */
    public List<CartaAstral> getCartasSeleccionadas() {
        return new ArrayList<>(cartasSeleccionadas);
    }

    /** @return lista de predicciones generadas */
    public List<Prediccion> getPredicciones() {
        return new ArrayList<>(predicciones);
    }

    /** @return texto completo de la interpretación final */
    public String getInterpretacionFinal() {
        return interpretacionFinal;
    }

    /** @return fecha en que se realizó la lectura */
    public LocalDate getFecha() {
        return fecha;
    }
}