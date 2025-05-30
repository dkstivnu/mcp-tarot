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
            case 6: // Los Enamorados
                this.significadosGenerales = Arrays.asList(
                        "Representa elección y armonía afectiva",
                        "Simboliza el amor, la unión y la conexión profunda",
                        "Indica decisiones que afectan el corazón"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Armonía y compromiso en relaciones",
                        "Decisión alineada con los valores del amor",
                        "Apertura a nuevas posibilidades románticas"
                );
                this.significadosAlReves = Arrays.asList(
                        "Duda o indecisión en el amor",
                        "Conflictos o desequilibrios afectivos",
                        "Elecciones apresuradas sin reflexión"
                );
                this.palabrasClave = Arrays.asList(
                        "Amor", "Decisión", "Unión", "Armonía", "Relación"
                );
                break;

            case 7: // El Carro
                this.significadosGenerales = Arrays.asList(
                        "Representa victoria y determinación",
                        "Simboliza avance rápido y control",
                        "Indica superar obstáculos con fuerza de voluntad"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Triunfo gracias al esfuerzo",
                        "Dirección y enfoque claros",
                        "Control firme sobre los desafíos"
                );
                this.significadosAlReves = Arrays.asList(
                        "Falta de dirección o dispersión",
                        "Obstáculos que retrasan el progreso",
                        "Exceso de impulsividad sin control"
                );
                this.palabrasClave = Arrays.asList(
                        "Victoria", "Determinación", "Control", "Éxito", "Progreso"
                );
                break;

            case 8: // La Justicia
                this.significadosGenerales = Arrays.asList(
                        "Representa equilibrio y verdad",
                        "Simboliza justicia y responsabilidad",
                        "Indica decisiones imparciales"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Decisiones justas y ponderadas",
                        "Responsabilidad y honestidad",
                        "Armonía a través del equilibrio"
                );
                this.significadosAlReves = Arrays.asList(
                        "Injusticia o parcialidad",
                        "Falta de responsabilidad",
                        "Resultados desequilibrados"
                );
                this.palabrasClave = Arrays.asList(
                        "Justicia", "Equilibrio", "Verdad", "Responsabilidad", "Imparcialidad"
                );
                break;

            case 9: // El Ermitaño
                this.significadosGenerales = Arrays.asList(
                        "Representa introspección y sabiduría interior",
                        "Simboliza soledad elegida para la reflexión",
                        "Indica búsqueda de la verdad interna"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Claridad obtenida en soledad",
                        "Consejos sabios y guía interna",
                        "Momento de retiro y meditación"
                );
                this.significadosAlReves = Arrays.asList(
                        "Aislamiento excesivo o soledad negativa",
                        "Falta de dirección interior",
                        "Rehúso a buscar ayuda"
                );
                this.palabrasClave = Arrays.asList(
                        "Sabiduría", "Introspección", "Guía", "Soledad", "Reflexión"
                );
                break;

            case 10: // La Rueda de la Fortuna
                this.significadosGenerales = Arrays.asList(
                        "Representa cambios y ciclos de la vida",
                        "Simboliza suerte y destinos cambiantes",
                        "Indica oportunidad y transformación"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Buen momento de fortuna",
                        "Ciclos que favorecen el crecimiento",
                        "Impactos positivos del destino"
                );
                this.significadosAlReves = Arrays.asList(
                        "Resistencia al cambio",
                        "Suerte inestable o imprevisible",
                        "Oportunidades perdidas"
                );
                this.palabrasClave = Arrays.asList(
                        "Cambio", "Destino", "Ciclo", "Fortuna", "Transformación"
                );
                break;

            case 11: // La Fuerza
                this.significadosGenerales = Arrays.asList(
                        "Representa coraje y compasión",
                        "Simboliza dominio de impulsos con suavidad",
                        "Indica poder interno y paciencia"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Coraje con amor y empatía",
                        "Control amable de situaciones",
                        "Resistencia serena"
                );
                this.significadosAlReves = Arrays.asList(
                        "Impulsividad o agresividad",
                        "Falta de paciencia",
                        "Debilidad interna"
                );
                this.palabrasClave = Arrays.asList(
                        "Coraje", "Compasión", "Paciencia", "Fortaleza", "Control"
                );
                break;

            case 12: // El Colgado
                this.significadosGenerales = Arrays.asList(
                        "Representa sacrificio y nueva perspectiva",
                        "Simboliza pausa intencional y reflexión",
                        "Indica cambio de enfoque"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Aceptación voluntaria de pausa",
                        "Nueva visión liberadora",
                        "Comprensión profunda"
                );
                this.significadosAlReves = Arrays.asList(
                        "Estancamiento o inmovilidad",
                        "Victimismo sin cambio",
                        "Resistencia al sacrificio"
                );
                this.palabrasClave = Arrays.asList(
                        "Sacrificio", "Perspectiva", "Pausa", "Reflexión", "Liberación"
                );
                break;

            case 13: // La Muerte
                this.significadosGenerales = Arrays.asList(
                        "Representa transformación y renacimiento",
                        "Simboliza finales necesarios",
                        "Indica cierre de ciclos"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Finales que permiten nuevos comienzos",
                        "Liberación de lo viejo",
                        "Renovación profunda"
                );
                this.significadosAlReves = Arrays.asList(
                        "Miedo al cambio",
                        "Resistencia a soltar el pasado",
                        "Estancamiento"
                );
                this.palabrasClave = Arrays.asList(
                        "Transformación", "Final", "Renacimiento", "Liberación", "Ciclo"
                );
                break;
            case 14: // La Templanza
                this.significadosGenerales = Arrays.asList(
                        "Representa equilibrio y armonía",
                        "Simboliza moderación y paciencia",
                        "Indica mezcla de elementos opuestos"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Equilibrio y adaptación",
                        "Paciencia en el proceso",
                        "Fusión armoniosa"
                );
                this.significadosAlReves = Arrays.asList(
                        "Desequilibrio o exceso",
                        "Impaciencia",
                        "Incompatibilidad de elementos"
                );
                this.palabrasClave = Arrays.asList(
                        "Equilibrio", "Moderación", "Paciencia", "Armonía", "Adaptación"
                );
                break;

            case 15: // El Diablo
                this.significadosGenerales = Arrays.asList(
                        "Representa ataduras y tentaciones",
                        "Simboliza materialismo y obsesiones",
                        "Indica la sombra personal"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Reconocimiento de cadenas propias",
                        "Tentaciones claras",
                        "Examinar dependencias"
                );
                this.significadosAlReves = Arrays.asList(
                        "Liberación de ataduras",
                        "Rechazo de tentaciones",
                        "Empoderamiento"
                );
                this.palabrasClave = Arrays.asList(
                        "Tentación", "Atadura", "Sombra", "Materialismo", "Obsesión"
                );
                break;

            case 16: // La Torre
                this.significadosGenerales = Arrays.asList(
                        "Representa ruptura y revelación",
                        "Simboliza caos necesario",
                        "Indica caída de falsas estructuras"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Cambio abrupto pero liberador",
                        "Verdades expuestas",
                        "Transformación forzada"
                );
                this.significadosAlReves = Arrays.asList(
                        "Miedo a la destrucción",
                        "Resistencia al cambio",
                        "Caída inesperada"
                );
                this.palabrasClave = Arrays.asList(
                        "Ruptura", "Caos", "Revelación", "Destrucción", "Renovación"
                );
                break;

            case 17: // La Estrella
                this.significadosGenerales = Arrays.asList(
                        "Representa esperanza y guía",
                        "Simboliza inspiración y paz",
                        "Indica curación espiritual"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Renovación de la fe",
                        "Optimismo y claridad",
                        "Inspiración creativa"
                );
                this.significadosAlReves = Arrays.asList(
                        "Desilusión o falta de fe",
                        "Pesimismo",
                        "Bloqueo creativo"
                );
                this.palabrasClave = Arrays.asList(
                        "Esperanza", "Inspiración", "Paz", "Curación", "Fe"
                );
                break;

            case 18: // La Luna
                this.significadosGenerales = Arrays.asList(
                        "Representa intuición y misterio",
                        "Simboliza ilusiones y sueños",
                        "Indica el inconsciente"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Claridad en lo oculto",
                        "Descubrimiento de verdades internas",
                        "Conexión con sueños"
                );
                this.significadosAlReves = Arrays.asList(
                        "Confusión o engaño",
                        "Miedos irracionales",
                        "Negación del inconsciente"
                );
                this.palabrasClave = Arrays.asList(
                        "Intuición", "Misterio", "Sueño", "Ilusión", "Subconsciente"
                );
                break;

            case 19: // El Sol
                this.significadosGenerales = Arrays.asList(
                        "Representa éxito y vitalidad",
                        "Simboliza alegría y claridad",
                        "Indica energía positiva"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Triunfo y felicidad",
                        "Iluminación de la verdad",
                        "Optimismo radiante"
                );
                this.significadosAlReves = Arrays.asList(
                        "Temor al éxito",
                        "Falta de claridad",
                        "Alegría reprimida"
                );
                this.palabrasClave = Arrays.asList(
                        "Éxito", "Vitalidad", "Alegría", "Claridad", "Optimismo"
                );
                break;

            case 20: // El Juicio
                this.significadosGenerales = Arrays.asList(
                        "Representa renacimiento y evaluación",
                        "Simboliza despertar y perdón",
                        "Indica juicio justo"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Reconocimiento de errores pasados",
                        "Segunda oportunidad",
                        "Crecimiento moral"
                );
                this.significadosAlReves = Arrays.asList(
                        "Culpa excesiva",
                        "Resistencia al perdón",
                        "Juicio injusto"
                );
                this.palabrasClave = Arrays.asList(
                        "Renacimiento", "Evaluación", "Perdón", "Despertar", "Justicia"
                );
                break;

            case 21: // El Mundo
                this.significadosGenerales = Arrays.asList(
                        "Representa plenitud y logro",
                        "Simboliza cierre de ciclos",
                        "Indica armonía universal"
                );
                this.significadosAlDerecho = Arrays.asList(
                        "Éxito completo y satisfacción",
                        "Unidad con lo divino",
                        "Logro de metas"
                );
                this.significadosAlReves = Arrays.asList(
                        "Sensación de incompletitud",
                        "Resistencia a finalizar",
                        "Metas inalcanzables"
                );
                this.palabrasClave = Arrays.asList(
                        "Plenitud", "Logro", "Unidad", "Ciclo", "Armonía"
                );
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
    @Override
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

