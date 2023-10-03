/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.services;

import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.dto.TipoDto;
import com.my_company.eapp.model.TipoExample;
import java.util.List;

public interface TipoService {
    long countByExample(TipoExample example);
    
    int deleteByExample(TipoExample example);
    
    int deleteByPrimaryKey(String codTipo);
    
    int insert(TipoDto tipoDto);
    
    int insertSelective(Tipo row);
    
     List<TipoDto> selectByExample();
    
    TipoDto selectByPrimaryKey(String codTipo);
    
    int updateByExampleSelective(Tipo row, TipoExample example);
    
    int updateByExample(Tipo row, TipoExample example);
    
    int updateByPrimaryKeySelective(TipoDto tipoDto);
    
    int updateByPrimaryKey(Tipo row);

     List<TipoDto> selectByCategoriaPrimaryKey(Integer idCategoria);
}
