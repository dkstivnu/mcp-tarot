package com.tarot.model;

import java.util.Date;

public enum Zodiaco {
    Aries("Aries"),
    Tauro("Tauro"),
    Geminis("Géminis"),
    Cancer("Cáncer"),
    Leo("Leo"),
    Libra("Libra"),
    Escorpio("Escorpio"),
    Sagitario("Sagitario"),
    Capricornio("Capricornio"),
    Acuario("Acuario"),
    Piscis("Piscis");


    private String name;
    private Date startDate;
    private Date endDate;

    Zodiaco(String nombre) {
        this.name = nombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
