/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.my_company.eapp.services;

import com.my_company.eapp.dto.SignificadoDto;

import java.util.List;

public interface SignificadoService {
    List<SignificadoDto> getAllSignificados();
    SignificadoDto getSignificadoById(Integer id);
    int createSignificado(SignificadoDto significadoDto);
    int updateSignificado(SignificadoDto significadoDto);
    int deleteSignificado(Integer id);
    List<SignificadoDto> selectByPalabraFrasePrimaryKey(Integer idPalabraFrase);
}
