package com.tarot.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArcanoMenor implements CartaAstral {

    private final int id;
    private final String nombre;
    private final String palo;
    private final int numero;
    private final String elemento;
    private final String area;
    private List<String> significadosGenerales;
    private List<String> significadosAlDerecho;
    private List<String> significadosAlReves;
    private List<String> palabrasClave;
    private final int probabilidad; // Porcentaje de probabilidad de cumplimiento

    // Enumeración para los palos
    public enum Palo {
        COPAS("Copas", "Agua", "Emocional", "emociones"),
        ESPADAS("Espadas", "Aire", "Mental", "pensamientos"),
        BASTOS("Bastos", "Fuego", "Energético", "acción"),
        OROS("Oros", "Tierra", "Material", "recursos");

        private final String nombre;
        private final String elemento;
        private final String area;
        private final String enfoque;

        Palo(String nombre, String elemento, String area, String enfoque) {
            this.nombre = nombre;
            this.elemento = elemento;
            this.area = area;
            this.enfoque = enfoque;
        }

        public String getNombre() { return nombre; }
        public String getElemento() { return elemento; }
        public String getArea() { return area; }
        public String getEnfoque() { return enfoque; }
    }

    // Constructor
    public ArcanoMenor(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo.getNombre();
        this.elemento = palo.getElemento();
        this.area = palo.getArea();
        this.probabilidad = calcularProbabilidad(numero);

        // Generar ID único: número + offset del palo
        this.id = numero + (getPaloOffset(palo) * 100);
        this.nombre = construirNombre(numero, palo);

        inicializarSignificados(numero, palo);
    }

    private int getPaloOffset(Palo palo) {
        switch (palo) {
            case COPAS: return 1;
            case ESPADAS: return 2;
            case BASTOS: return 3;
            case OROS: return 4;
            default: return 0;
        }
    }

    private String construirNombre(int numero, Palo palo) {
        String nombreCarta;
        switch (numero) {
            case 1: nombreCarta = "As"; break;
            case 11: nombreCarta = "Sota"; break;
            case 12: nombreCarta = "Caballero"; break;
            case 13: nombreCarta = "Reina"; break;
            case 14: nombreCarta = "Rey"; break;
            default: nombreCarta = String.valueOf(numero); break;
        }
        return nombreCarta + " de " + palo.getNombre();
    }

    private int calcularProbabilidad(int numero) {
        // Sistema de probabilidad basado en el número de la carta
        switch (numero) {
            case 1: return 95; // As - muy alta probabilidad
            case 2: return 70; // Dualidad - probabilidad moderada-alta
            case 3: return 80; // Creatividad - alta probabilidad
            case 4: return 60; // Estabilidad - probabilidad moderada
            case 5: return 45; // Conflicto - probabilidad baja-moderada
            case 6: return 75; // Armonía - probabilidad alta
            case 7: return 55; // Desafío - probabilidad moderada
            case 8: return 85; // Logro - probabilidad muy alta
            case 9: return 65; // Culminación - probabilidad moderada-alta
            case 10: return 90; // Completitud - probabilidad muy alta
            case 11: return 50; // Sota - probabilidad moderada (juventud)
            case 12: return 70; // Caballero - probabilidad moderada-alta (acción)
            case 13: return 80; // Reina - probabilidad alta (madurez)
            case 14: return 85; // Rey - probabilidad muy alta (maestría)
            default: return 50;
        }
    }

    private void inicializarSignificados(int numero, Palo palo) {
        // Significados especiales para cartas de corte
        if (numero >= 11 && numero <= 14) {
            inicializarCartasCorte(numero, palo);
        } else if (numero == 1) {
            inicializarAs(palo);
        } else {
            inicializarCartaNumerica(numero, palo);
        }
    }

    private void inicializarAs(Palo palo) {
        // Significados especiales del As independientemente del palo
        this.significadosGenerales = Arrays.asList(
                "Representa nuevos comienzos y potencial puro en el área de " + palo.getEnfoque(),
                "Simboliza la semilla de todas las posibilidades en " + palo.getArea().toLowerCase(),
                "Indica el punto de partida perfecto para manifestar " + palo.getEnfoque()
        );

        this.significadosAlDerecho = Arrays.asList(
                "Oportunidad dorada para nuevos comienzos",
                "Energía pura y sin obstáculos en " + palo.getEnfoque(),
                "Momento perfecto para iniciar en el área " + palo.getArea().toLowerCase()
        );

        this.significadosAlReves = Arrays.asList(
                "Oportunidad desperdiciada o retrasada",
                "Bloqueo en los nuevos comienzos de " + palo.getEnfoque(),
                "Dudas sobre el potencial en " + palo.getArea().toLowerCase()
        );

        this.palabrasClave = Arrays.asList("Nuevo comienzo", "Potencial", "Oportunidad",
                palo.getEnfoque().substring(0, 1).toUpperCase() + palo.getEnfoque().substring(1),
                "Semilla");
    }

    private void inicializarCartasCorte(int numero, Palo palo) {
        switch (numero) {
            case 11: // Sota
                this.significadosGenerales = Arrays.asList(
                        "Representa juventud y aprendizaje en " + palo.getEnfoque(),
                        "Simboliza mensajes y noticias relacionadas con " + palo.getArea().toLowerCase(),
                        "Indica energía juvenil enfocada en " + palo.getEnfoque()
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Mensajes positivos y aprendizaje",
                        "Entusiasmo juvenil en " + palo.getEnfoque(),
                        "Nuevas perspectivas en " + palo.getArea().toLowerCase()
                );
                this.significadosAlReves = Arrays.asList(
                        "Inmadurez o mensajes confusos",
                        "Resistencia al aprendizaje",
                        "Energía mal dirigida en " + palo.getEnfoque()
                );
                this.palabrasClave = Arrays.asList("Juventud", "Mensaje", "Aprendizaje", "Entusiasmo", palo.getEnfoque());
                break;

            case 12: // Caballero
                this.significadosGenerales = Arrays.asList(
                        "Representa acción y movimiento en " + palo.getEnfoque(),
                        "Simboliza impulso y determinación",
                        "Indica cambios rápidos en " + palo.getArea().toLowerCase()
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Acción decidida y efectiva",
                        "Progreso rápido en " + palo.getEnfoque(),
                        "Valentía para enfrentar desafíos"
                );
                this.significadosAlReves = Arrays.asList(
                        "Impulsividad o acciones precipitadas",
                        "Falta de dirección clara",
                        "Energía dispersa en " + palo.getEnfoque()
                );
                this.palabrasClave = Arrays.asList("Acción", "Movimiento", "Impulso", "Cambio", palo.getEnfoque());
                break;

            case 13: // Reina
                this.significadosGenerales = Arrays.asList(
                        "Representa sabiduría emocional y nurturing en " + palo.getEnfoque(),
                        "Simboliza intuición madura y comprensión",
                        "Indica liderazgo empático en " + palo.getArea().toLowerCase()
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Sabiduría intuitiva y cuidado",
                        "Liderazgo compasivo en " + palo.getEnfoque(),
                        "Equilibrio emocional y madurez"
                );
                this.significadosAlReves = Arrays.asList(
                        "Sobreprotección o manipulación emocional",
                        "Desequilibrio en " + palo.getEnfoque(),
                        "Inseguridad disfrazada de control"
                );
                this.palabrasClave = Arrays.asList("Sabiduría", "Intuición", "Cuidado", "Madurez", palo.getEnfoque());
                break;

            case 14: // Rey
                this.significadosGenerales = Arrays.asList(
                        "Representa maestría y liderazgo en " + palo.getEnfoque(),
                        "Simboliza autoridad y experiencia",
                        "Indica dominio completo de " + palo.getArea().toLowerCase()
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Liderazgo sabio y experimentado",
                        "Maestría completa en " + palo.getEnfoque(),
                        "Autoridad respetada y merecida"
                );
                this.significadosAlReves = Arrays.asList(
                        "Autoritarismo o abuso de poder",
                        "Rigidez excesiva en " + palo.getEnfoque(),
                        "Liderazgo tóxico o inefectivo"
                );
                this.palabrasClave = Arrays.asList("Maestría", "Liderazgo", "Autoridad", "Experiencia", palo.getEnfoque());
                break;
        }
    }

    private void inicializarCartaNumerica(int numero, Palo palo) {
        // Significados base según el número
        String enfoqueCapitalizado = palo.getEnfoque().substring(0, 1).toUpperCase() + palo.getEnfoque().substring(1);

        switch (numero) {
            case 2:
                this.significadosGenerales = Arrays.asList(
                        "Representa dualidad y elección en " + palo.getEnfoque(),
                        "Simboliza cooperación y equilibrio",
                        "Indica decisiones importantes en " + palo.getArea().toLowerCase()
                );
                break;
            case 3:
                this.significadosGenerales = Arrays.asList(
                        "Representa creatividad y expansión en " + palo.getEnfoque(),
                        "Simboliza grupo y colaboración",
                        "Indica crecimiento en " + palo.getArea().toLowerCase()
                );
                break;
            case 4:
                this.significadosGenerales = Arrays.asList(
                        "Representa estabilidad y estructura en " + palo.getEnfoque(),
                        "Simboliza fundamentos sólidos",
                        "Indica consolidación en " + palo.getArea().toLowerCase()
                );
                break;
            case 5:
                this.significadosGenerales = Arrays.asList(
                        "Representa conflicto y desafío en " + palo.getEnfoque(),
                        "Simboliza pérdida y lucha",
                        "Indica crisis en " + palo.getArea().toLowerCase()
                );
                break;
            case 6:
                this.significadosGenerales = Arrays.asList(
                        "Representa armonía y generosidad en " + palo.getEnfoque(),
                        "Simboliza dar y recibir equilibradamente",
                        "Indica sanación en " + palo.getArea().toLowerCase()
                );
                break;
            case 7:
                this.significadosGenerales = Arrays.asList(
                        "Representa evaluación y paciencia en " + palo.getEnfoque(),
                        "Simboliza reflexión y espera",
                        "Indica reevaluación en " + palo.getArea().toLowerCase()
                );
                break;
            case 8:
                this.significadosGenerales = Arrays.asList(
                        "Representa movimiento rápido y progreso en " + palo.getEnfoque(),
                        "Simboliza acción decidida",
                        "Indica avances en " + palo.getArea().toLowerCase()
                );
                break;
            case 9:
                this.significadosGenerales = Arrays.asList(
                        "Representa culminación y resistencia en " + palo.getEnfoque(),
                        "Simboliza preparación final",
                        "Indica fuerza interior en " + palo.getArea().toLowerCase()
                );
                break;
            case 10:
                this.significadosGenerales = Arrays.asList(
                        "Representa completitud y carga en " + palo.getEnfoque(),
                        "Simboliza fin de ciclo",
                        "Indica plenitud en " + palo.getArea().toLowerCase()
                );
                break;
            default:
                this.significadosGenerales = Arrays.asList("Significado en desarrollo para " + palo.getEnfoque());
                break;
        }

        // Significados genéricos al derecho y al revés para cartas numéricas
        this.significadosAlDerecho = Arrays.asList(
                "Energía positiva fluyendo en " + palo.getEnfoque(),
                "Desarrollo favorable en " + palo.getArea().toLowerCase(),
                "Manifestación clara de " + enfoqueCapitalizado
        );

        this.significadosAlReves = Arrays.asList(
                "Bloqueos o retrasos en " + palo.getEnfoque(),
                "Desequilibrio en " + palo.getArea().toLowerCase(),
                "Resistencia interna hacia " + enfoqueCapitalizado
        );

        this.palabrasClave = Arrays.asList(
                "Número " + numero,
                enfoqueCapitalizado,
                palo.getArea(),
                "Probabilidad " + probabilidad + "%",
                palo.getElemento()
        );
    }

    // Implementación de la interfaz CartaAstral
    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String obtenerSignificadoGeneral() {
        if (significadosGenerales == null || significadosGenerales.isEmpty()) {
            return "Sin significado disponible";
        }
        Random random = new Random();
        return significadosGenerales.get(random.nextInt(significadosGenerales.size()));
    }

    @Override
    public String obtenerArea() {
        return this.area;
    }

    @Override
    public String obtenerSignificadoAlDerecho() {
        if (significadosAlDerecho == null || significadosAlDerecho.isEmpty()) {
            return "Sin significado al derecho disponible";
        }
        Random random = new Random();
        return significadosAlDerecho.get(random.nextInt(significadosAlDerecho.size()));
    }

    @Override
    public String obtenerSignificadoAlReves() {
        if (significadosAlReves == null || significadosAlReves.isEmpty()) {
            return "Sin significado al revés disponible";
        }
        Random random = new Random();
        return significadosAlReves.get(random.nextInt(significadosAlReves.size()));
    }

    @Override
    public String obtenerElemento() {
        return this.elemento;
    }

    @Override
    public String obtenerPalabrasClave() {
        if (palabrasClave == null || palabrasClave.isEmpty()) {
            return "Sin palabras clave disponibles";
        }
        return String.join(", ", palabrasClave);
    }

    // Métodos adicionales específicos de ArcanoMenor
    public String getPalo() {
        return this.palo;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getProbabilidad() {
        return this.probabilidad;
    }

    public String obtenerEnfoquePalo() {
        for (Palo p : Palo.values()) {
            if (p.getNombre().equals(this.palo)) {
                return p.getEnfoque();
            }
        }
        return "enfoque desconocido";
    }

    public String obtenerInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("=== ").append(nombre).append(" (ID: ").append(id).append(") ===\n");
        info.append("Palo: ").append(palo).append("\n");
        info.append("Número: ").append(numero).append("\n");
        info.append("Elemento: ").append(elemento).append("\n");
        info.append("Área: ").append(area).append("\n");
        info.append("Enfoque: ").append(obtenerEnfoquePalo()).append("\n");
        info.append("Probabilidad de cumplimiento: ").append(probabilidad).append("%\n");
        info.append("Palabras clave: ").append(obtenerPalabrasClave()).append("\n\n");

        info.append("Significados Generales:\n");
        if (significadosGenerales != null) {
            for (String sig : significadosGenerales) {
                info.append("• ").append(sig).append("\n");
            }
        }

        info.append("\nSignificados Al Derecho:\n");
        if (significadosAlDerecho != null) {
            for (String sig : significadosAlDerecho) {
                info.append("• ").append(sig).append("\n");
            }
        }

        info.append("\nSignificados Al Revés:\n");
        if (significadosAlReves != null) {
            for (String sig : significadosAlReves) {
                info.append("• ").append(sig).append("\n");
            }
        }

        return info.toString();
    }

    // Método para evaluar si la predicción se cumplirá según la probabilidad
    public boolean evaluarCumplimiento() {
        Random random = new Random();
        return random.nextInt(100) < this.probabilidad;
    }

    public String obtenerMensajeProbabilidad() {
        String nivel;
        if (probabilidad >= 85) {
            nivel = "muy alta";
        } else if (probabilidad >= 70) {
            nivel = "alta";
        } else if (probabilidad >= 55) {
            nivel = "moderada";
        } else if (probabilidad >= 40) {
            nivel = "baja";
        } else {
            nivel = "muy baja";
        }

        return "Esta carta tiene una probabilidad " + nivel + " (" + probabilidad + "%) de manifestarse en la realidad.";
    }
}