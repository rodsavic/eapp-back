/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.controller;

import com.my_company.eapp.dao.TipoMapper;
import com.my_company.eapp.model.Tipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoMapper tipoMapper;

    @Autowired
    public TipoController(TipoMapper tipoMapper) {
        this.tipoMapper = tipoMapper;
    }

    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoMapper.selectByExample(null);
    }

    @GetMapping("/{id}")
    public Tipo getTipoById(@PathVariable Integer id) {
        return tipoMapper.selectByPrimaryKey(id);
    }

    @PostMapping
    public int createTipo(@RequestBody Tipo tipo) {
        return tipoMapper.insertSelective(tipo);
    }

    @PutMapping("/{id}")
    public int updateTipo(@PathVariable Integer id, @RequestBody Tipo tipo) {
        tipo.setIdTipo(id);
        return tipoMapper.updateByPrimaryKeySelective(tipo);
    }

    @DeleteMapping("/{id}")
    public int deleteTipo(@PathVariable Integer id) {
        return tipoMapper.deleteByPrimaryKey(id);
    }
}

