package com.my_company.eapp.services.impl;

import com.my_company.eapp.dao.TipoMapper;
import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.model.TipoExample;
import com.my_company.eapp.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoMapper tipoMapper;

    @Override
    public long countByExample(TipoExample example) {
        return tipoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TipoExample example) {
        return tipoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String codTipo) {
        return tipoMapper.deleteByPrimaryKey(codTipo);
    }

    @Override
    public int insert(Tipo row) {
        return tipoMapper.insert(row);
    }

    @Override
    public int insertSelective(Tipo row) {
        return tipoMapper.insertSelective(row);
    }

    @Override
    public List<Tipo> selectByExample() {
        return tipoMapper.selectByExample(null);
    }

    @Override
    public Tipo selectByPrimaryKey(String codTipo) {
        return tipoMapper.selectByPrimaryKey(codTipo);
    }

    @Override
    public int updateByExampleSelective(Tipo row, TipoExample example) {
        return tipoMapper.updateByExampleSelective(row, example);
    }

    @Override
    public int updateByExample(Tipo row, TipoExample example) {
        return tipoMapper.updateByExample(row, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Tipo row) {
        return tipoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Tipo row) {
        return tipoMapper.updateByPrimaryKey(row);
    }

    @Override
    public List<Tipo> selectByCategoriaPrimaryKey(Integer idCategoria) {
        return tipoMapper.selectByCategoria(idCategoria);
    }
}
