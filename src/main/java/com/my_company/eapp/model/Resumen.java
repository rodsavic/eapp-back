package com.my_company.eapp.model;

import java.util.Date;

public class Resumen {
    private Integer idResumen;

    private Integer idPractica;

    private Date tiempo;

    private Integer aciertos;

    private Integer palabrasPracticadas;

    public Integer getIdResumen() {
        return idResumen;
    }

    public void setIdResumen(Integer idResumen) {
        this.idResumen = idResumen;
    }

    public Integer getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getAciertos() {
        return aciertos;
    }

    public void setAciertos(Integer aciertos) {
        this.aciertos = aciertos;
    }

    public Integer getPalabrasPracticadas() {
        return palabrasPracticadas;
    }

    public void setPalabrasPracticadas(Integer palabrasPracticadas) {
        this.palabrasPracticadas = palabrasPracticadas;
    }
}