/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.my_company.eapp.services;

import com.my_company.eapp.model.Significado;

import java.util.List;

public interface SignificadoService {
    List<Significado> getAllSignificados();
    Significado getSignificadoById(Integer id);
    int createSignificado(Significado significado);
    int updateSignificado(Significado significado);
    int deleteSignificado(Integer id);
}
