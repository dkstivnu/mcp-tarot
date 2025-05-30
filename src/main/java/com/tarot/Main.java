package com.tarot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tarot.model.ArcanoMayor;
import com.tarot.model.ArcanoMenor;
import com.tarot.model.CartaAstral;
import com.tarot.model.Lectura;
import com.tarot.model.Persona;
import com.tarot.model.Tarot;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Solicita datos de la persona
            System.out.println("=== Bienvenido/a al Tarot Astral ===");
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            LocalDate fechaNacimiento = null;
            while (fechaNacimiento == null) {
                try {
                    System.out.print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
                    String fechaInput = scanner.nextLine();
                    fechaNacimiento = LocalDate.parse(fechaInput);
                } catch (Exception e) {
                    System.out.println("Formato inválido. Intente de nuevo.");
                }
            }

            // Crear la persona
            Persona persona = new Persona(fechaNacimiento, nombre);

            // Crear algunos Arcanos Mayores y Menores para el mazo
            ArcanoMayor elLoco = new ArcanoMayor(0, "El Loco", "Aire", "Comienzos");
            ArcanoMenor dosCopas = new ArcanoMenor(2, ArcanoMenor.Palo.COPAS);
            ArcanoMenor asBastos = new ArcanoMenor(1, ArcanoMenor.Palo.BASTOS);

            // Agregar cartas al mazo de la persona
            Tarot tarot = persona.getTarot();
            tarot.getCartas().add(elLoco);
            tarot.getCartas().add(dosCopas);
            tarot.getCartas().add(asBastos);

            // Seleccionar cartas para la lectura (puede ser todas del mazo)
            List<CartaAstral> seleccionadas = new ArrayList<>(tarot.getCartas());

            // Crear la lectura de tarot
            Lectura lectura = new Lectura(persona, seleccionadas);

            // Crear una predicción y agregarla a la lectura
            lectura.crearYAgregarPrediccion(tarot);

            // Generar la interpretación final
            lectura.generarInterpretacionFinal();

            // --- Solo mostrar la interpretación final ---
            System.out.println("\nInterpretación final de la lectura:");
            System.out.println(lectura.getInterpretacionFinal());
        }
    }
}