package com.my_company.eapp.services;

import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample;
import java.util.List;

public interface PalabraFraseService {
    List<PalabraFrase> getAllPalabrasFrases();
    PalabraFrase getPalabraFraseById(Integer id);
    int createPalabraFrase(PalabraFrase palabraFrase);
    int updatePalabraFrase(Integer id, PalabraFrase palabraFrase);
    int deletePalabraFrase(Integer id);
    int getPalabraFraseIdByContenido(String contenido);
    List<PalabraFrase> buscarPalabrasConFiltros(PalabraFraseExample example);
}