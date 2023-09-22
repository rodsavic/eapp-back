package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.PalabraFraseMapper;
import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PalabraFraseServiceImpl implements PalabraFraseService {

    private final PalabraFraseMapper palabraFraseMapper;
    PalabraFraseExample example = new PalabraFraseExample();
    PalabraFraseExample.Criteria criteria = example.createCriteria();

    @Autowired
    public PalabraFraseServiceImpl(PalabraFraseMapper palabraFraseMapper) {
        this.palabraFraseMapper = palabraFraseMapper;
    }

    @Override
    public List<PalabraFrase> getAllPalabrasFrases() {
        return palabraFraseMapper.selectByExample(null);
    }

    @Override
    public PalabraFrase getPalabraFraseById(Integer id) {
        return palabraFraseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createPalabraFrase(PalabraFrase palabraFrase) {
        return palabraFraseMapper.insertSelective(palabraFrase);
    }

    @Override
    public int updatePalabraFrase(Integer id, PalabraFrase palabraFrase) {
        palabraFrase.setIdPalabraFrase(id);
        return palabraFraseMapper.updateByPrimaryKeySelective(palabraFrase);
    }

    @Override
    public int deletePalabraFrase(Integer id) {
        return palabraFraseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getPalabraFraseIdByContenido(String contenido) {
        return palabraFraseMapper.getPalabraFraseIdByContenido(contenido);
    }

    @Override
    public List<PalabraFrase> buscarPalabrasConFiltros(PalabraFraseExample example) {
        System.out.println("Ingresa al PalabraFraseServiceImpl - buscarPalabrasConFiltros");
        return palabraFraseMapper.selectByExample(example);
    }
    
    
}