package com.tarot.tools;

import com.tarot.model.Lectura;
import com.tarot.model.Persona;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenPrediccion {


    McpSchema.JsonSchema schema = new McpSchema.JsonSchema(
            "object", // tipo del schema principal
            createProperties(), // mapa de propiedades
            List.of("fechaNacimiento"), // campos requeridos
            false // no permitir propiedades adicionales
    );

    public McpServerFeatures.SyncToolSpecification generacionPrediccion = new McpServerFeatures.SyncToolSpecification(
            new McpSchema.Tool("Generar Lectura",
                    "Genera la lectura del tarot a partir de la fecha de nacimiento",
                    schema),
            (exchange, arguments) -> {

                String fechaNacimiento = (String) arguments.get("fechaNacimiento");

                LocalDate fechaMD = formatearFecha(fechaNacimiento);

                Persona p = new Persona(fechaMD, "Mansito");

                p.getTarot().crearMazo();

                Lectura l = new Lectura(p, p.getTarot().getCartas());
                l.crearYAgregarPrediccion(p.getTarot());

               l.generarInterpretacionFinal();

               String response = l.getInterpretacionFinal();

                return new McpSchema.CallToolResult(response, false);
            }
    );
    private Map<String, Object> createProperties() {
        Map<String, Object> properties = new HashMap<>();

        // Definir la propiedad "fechaNacimiento"
        Map<String, Object> fechaNacimientoProperty = new HashMap<>();
        fechaNacimientoProperty.put("type", "string");
        fechaNacimientoProperty.put("description", "Fecha de nacimiento en formato YYYY-MM-DD");
        fechaNacimientoProperty.put("pattern", "^\\d{4}-\\d{2}-\\d{2}$");

        properties.put("fechaNacimiento", fechaNacimientoProperty);

        return properties;
    }

    private LocalDate formatearFecha(String fechaNacimiento) {
        try {
            return LocalDate.parse(fechaNacimiento);
        } catch (Exception e) {
            // En caso de error, devolver una fecha por defecto o lanzar excepción
            throw new IllegalArgumentException("Formato de fecha inválido: " + fechaNacimiento);
        }
    }
}
