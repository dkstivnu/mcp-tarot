package com.tarot.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArcanoMayor implements CartaAstral {

    private final int id;
    private final String nombre;
    private final String elemento;
    private final String area;
    private List<String> significadosGenerales;
    private List<String> significadosAlDerecho;
    private List<String> significadosAlReves;
    private List<String> palabrasClave;

    // Constructor
    public ArcanoMayor(int id, String nombre, String elemento, String area) {
        this.id = id;
        this.nombre = nombre;
        this.elemento = elemento;
        this.area = area;
        inicializarSignificados();
    }

    private void inicializarSignificados() {
        switch (this.id) {
            case 0: // El Loco
                this.significadosGenerales = Arrays.asList(
                        "Representa nuevos comienzos, espontaneidad y potencial ilimitado",
                        "Simboliza la inocencia, la aventura y el salto de fe hacia lo desconocido",
                        "Indica un momento de libertad total y confianza en el universo"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Nuevos comienzos llenos de posibilidades",
                        "Libertad para tomar decisiones sin limitaciones",
                        "Confianza ciega en el futuro y optimismo"
                );
                this.significadosAlReves = Arrays.asList(
                        "Imprudencia y falta de planificación",
                        "Miedo a tomar riesgos o salir de la zona de confort",
                        "Decisiones apresuradas que pueden traer consecuencias"
                );
                this.palabrasClave = Arrays.asList("Libertad", "Aventura", "Inocencia", "Nuevos comienzos", "Espontaneidad");
                break;

            case 1: // El Mago
                this.significadosGenerales = Arrays.asList(
                        "Representa la manifestación del poder personal y la creatividad",
                        "Simboliza la capacidad de transformar ideas en realidad",
                        "Indica el dominio de las habilidades y recursos disponibles"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Poder de manifestación y creación",
                        "Habilidades desarrolladas y confianza en uno mismo",
                        "Capacidad de influir en el entorno y lograr objetivos"
                );
                this.significadosAlReves = Arrays.asList(
                        "Manipulación o uso indebido del poder",
                        "Falta de confianza en las propias habilidades",
                        "Energía dispersa o mal dirigida"
                );
                this.palabrasClave = Arrays.asList("Manifestación", "Poder", "Habilidad", "Creatividad", "Influencia");
                break;

            case 2: // La Sacerdotisa
                this.significadosGenerales = Arrays.asList(
                        "Representa la intuición, los misterios y el conocimiento oculto",
                        "Simboliza la sabiduría interior y la conexión espiritual",
                        "Indica la necesidad de escuchar la voz interior"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Intuición desarrollada y sabiduría interior",
                        "Conexión profunda con el inconsciente",
                        "Acceso a conocimientos ocultos o esotéricos"
                );
                this.significadosAlReves = Arrays.asList(
                        "Desconexión de la intuición",
                        "Secretos que causan problemas",
                        "Ignorar las señales internas importantes"
                );
                this.palabrasClave = Arrays.asList("Intuición", "Misterio", "Sabiduría", "Espiritualidad", "Inconsciente");
                break;

            case 3: // La Emperatriz
                this.significadosGenerales = Arrays.asList(
                        "Representa la feminidad, la creatividad y la abundancia",
                        "Simboliza la maternidad, la fertilidad y el cuidado",
                        "Indica conexión con la naturaleza y los ciclos naturales"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Creatividad floreciente y abundancia material",
                        "Energía maternal y cuidado hacia otros",
                        "Conexión armoniosa con la naturaleza"
                );
                this.significadosAlReves = Arrays.asList(
                        "Creatividad bloqueada o estancada",
                        "Sobreprotección o dependencia excesiva",
                        "Desconexión de la feminidad o naturaleza"
                );
                this.palabrasClave = Arrays.asList("Feminidad", "Creatividad", "Abundancia", "Maternidad", "Naturaleza");
                break;

            case 4: // El Emperador
                this.significadosGenerales = Arrays.asList(
                        "Representa la autoridad, el liderazgo y la estructura",
                        "Simboliza el poder paternal y la protección",
                        "Indica estabilidad, orden y control sobre las circunstancias"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Liderazgo natural y autoridad respetada",
                        "Estructura sólida y organización eficiente",
                        "Protección y estabilidad para otros"
                );
                this.significadosAlReves = Arrays.asList(
                        "Autoritarismo excesivo o tiranía",
                        "Rigidez mental y falta de flexibilidad",
                        "Abuso de poder o control manipulador"
                );
                this.palabrasClave = Arrays.asList("Autoridad", "Liderazgo", "Estructura", "Protección", "Control");
                break;

            case 5: // El Hierofante
                this.significadosGenerales = Arrays.asList(
                        "Representa la sabiduría tradicional y las enseñanzas espirituales",
                        "Simboliza la conformidad con las normas establecidas",
                        "Indica la búsqueda de significado a través de instituciones"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Sabiduría tradicional y enseñanzas valiosas",
                        "Conformidad constructiva con normas sociales",
                        "Guía espiritual y mentor confiable"
                );
                this.significadosAlReves = Arrays.asList(
                        "Rebelión contra la autoridad establecida",
                        "Dogmatismo religioso o espiritual",
                        "Rechazo a las enseñanzas tradicionales"
                );
                this.palabrasClave = Arrays.asList("Tradición", "Enseñanza", "Espiritualidad", "Conformidad", "Sabiduría");
                break;
        }
    }

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
        if (significadosGenerales.isEmpty()) return "Sin significado disponible";
        Random random = new Random();
        return significadosGenerales.get(random.nextInt(significadosGenerales.size()));
    }

    @Override
    public String obtenerArea() {
        return this.area;
    }

    @Override
    public String obtenerSignificadoAlDerecho() {
        if (significadosAlDerecho.isEmpty()) return "Sin significado al derecho disponible";
        Random random = new Random();
        return significadosAlDerecho.get(random.nextInt(significadosAlDerecho.size()));
    }

    @Override
    public String obtenerSignificadoAlReves() {
        if (significadosAlReves.isEmpty()) return "Sin significado al revés disponible";
        Random random = new Random();
        return significadosAlReves.get(random.nextInt(significadosAlReves.size()));
    }

    @Override
    public String obtenerElemento() {
        return this.elemento;
    }

    @Override
    public String obtenerPalabrasClave() {
        return String.join(", ", palabrasClave);
    }

    // Método adicional para obtener todos los significados
    public String obtenerInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("=== ").append(nombre).append(" (ID: ").append(id).append(") ===\n");
        info.append("Elemento: ").append(elemento).append("\n");
        info.append("Área: ").append(area).append("\n");
        info.append("Palabras clave: ").append(obtenerPalabrasClave()).append("\n\n");

        info.append("Significados Generales:\n");
        for (String sig : significadosGenerales) {
            info.append("• ").append(sig).append("\n");
        }

        info.append("\nSignificados Al Derecho:\n");
        for (String sig : significadosAlDerecho) {
            info.append("• ").append(sig).append("\n");
        }

        info.append("\nSignificados Al Revés:\n");
        for (String sig : significadosAlReves) {
            info.append("• ").append(sig).append("\n");
        }

        return info.toString();
    }
}

