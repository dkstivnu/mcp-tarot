package com.tarot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tarot.model.CartaAstral;
import com.tarot.model.Lectura;
import com.tarot.model.Persona;

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

            // Agregar cartas al mazo de la persona
            persona.getTarot().crearMazo();

            // Seleccionar cartas para la lectura (puede ser todas del mazo)
            List<CartaAstral> seleccionadas = new ArrayList<>(persona.getTarot().getCartas());

            // Crear la lectura de tarot
            Lectura lectura = new Lectura(persona, seleccionadas);

            // Crear una predicción y agregarla a la lectura
            lectura.crearYAgregarPrediccion(persona.getTarot());

            // Generar la interpretación final
            lectura.generarInterpretacionFinal();

            // --- Solo mostrar la interpretación final ---
            System.out.println("\nInterpretación final de la lectura:");
            System.out.println(lectura.getInterpretacionFinal());
        }
    }
}