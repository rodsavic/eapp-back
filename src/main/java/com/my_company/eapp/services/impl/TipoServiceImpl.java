package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.TipoMapper;
import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    private final TipoMapper tipoMapper;

    @Autowired
    public TipoServiceImpl(TipoMapper tipoMapper) {
        this.tipoMapper = tipoMapper;
    }

    @Override
    public List<Tipo> getAllTipos() {
        return tipoMapper.selectByExample(null);
    }

    @Override
    public Tipo getTipoById(Integer id) {
        return tipoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int createTipo(Tipo tipo) {
        return tipoMapper.insertSelective(tipo);
    }

    @Override
    public int updateTipo(Integer id, Tipo tipo) {
        tipo.setIdTipo(id);
        return tipoMapper.updateByPrimaryKeySelective(tipo);
    }

    @Override
    public int deleteTipo(Integer id) {
        return tipoMapper.deleteByPrimaryKey(id);
    }
}
