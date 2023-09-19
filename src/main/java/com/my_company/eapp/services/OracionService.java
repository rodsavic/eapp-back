/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.my_company.eapp.services;

import com.my_company.eapp.model.Oracion;

import java.util.List;

public interface OracionService {
    List<Oracion> getAllOraciones();
    Oracion getOracionById(Integer id);
    int createOracion(Oracion oracion);
    int updateOracion(Oracion oracion);
    int deleteOracion(Integer id);
}