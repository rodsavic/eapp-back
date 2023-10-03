/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.dto;

import java.util.Date;

/**
 *
 * @author Sanchez
 */
public class SignificadoDto {

    private Integer idSignificado;

    private String descripcion;

    private Integer idPalabraFrase;

    private Date fechaRegistro;

    public Integer getIdSignificado() {
        return idSignificado;
    }

    public void setIdSignificado(Integer idSignificado) {
        this.idSignificado = idSignificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPalabraFrase() {
        return idPalabraFrase;
    }

    public void setIdPalabraFrase(Integer idPalabraFrase) {
        this.idPalabraFrase = idPalabraFrase;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
