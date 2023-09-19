/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.SignificadoMapper;
import com.my_company.eapp.model.Significado;
import com.my_company.eapp.services.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignificadoServiceImpl implements SignificadoService {

    private final SignificadoMapper significadoMapper;

    @Autowired
    public SignificadoServiceImpl(SignificadoMapper significadoMapper) {
        this.significadoMapper = significadoMapper;
    }

    @Override
    public List<Significado> getAllSignificados() {
        return significadoMapper.selectByExample(null);
    }

    @Override
    public Significado getSignificadoById(Integer id) {
        return significadoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createSignificado(Significado significado) {
        return significadoMapper.insertSelective(significado);
    }

    @Override
    public int updateSignificado(Significado significado) {
        return significadoMapper.updateByPrimaryKeySelective(significado);
    }

    @Override
    public int deleteSignificado(Integer id) {
        return significadoMapper.deleteByPrimaryKey(id);
    }
}