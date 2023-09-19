/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.services;

import com.my_company.eapp.model.Tipo;
import java.util.List;

public interface TipoService {
    List<Tipo> getAllTipos();
    Tipo getTipoById(Integer id);
    int createTipo(Tipo tipo);
    int updateTipo(Integer id, Tipo tipo);
    int deleteTipo(Integer id);
}
