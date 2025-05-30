package com.tarot.model;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Zodiaco {
    private static final NavigableMap<MonthDay,String> SIGNOS = new TreeMap<>();

    static {
        SIGNOS.put(MonthDay.of(1,20),"Acuario");
        SIGNOS.put(MonthDay.of(2,19),"Piscis");
        SIGNOS.put(MonthDay.of(3,21),"Aries");
        SIGNOS.put(MonthDay.of(4,20),"Tauro");
        SIGNOS.put(MonthDay.of(5,21),"Géminis");
        SIGNOS.put(MonthDay.of(6,21),"Cáncer");
        SIGNOS.put(MonthDay.of(7,23),"Leo");
        SIGNOS.put(MonthDay.of(8,23),"Virgo");
        SIGNOS.put(MonthDay.of(9,23),"Libra");
        SIGNOS.put(MonthDay.of(10,23),"Escorpio");
        SIGNOS.put(MonthDay.of(11,22),"Sagitario");
        SIGNOS.put(MonthDay.of(12,22),"Capricornio");
    }

    public static String determineSigno(LocalDate fecha) {
        MonthDay md = MonthDay.from(fecha);
        var entry = SIGNOS.floorEntry(md);
        return entry == null ? SIGNOS.lastEntry().getValue() : entry.getValue();
    }
}