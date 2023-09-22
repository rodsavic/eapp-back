/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my_company.eapp.controller;

import com.my_company.eapp.model.Tipo;
import com.my_company.eapp.services.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos")
public class TipoController {

     @Autowired
    private TipoService tipoService;
     
    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoService.selectByExample();
    }

    @GetMapping("/{codTipo}")
    public Tipo getTipoById(@PathVariable String codTipo) {
        return tipoService.selectByPrimaryKey(codTipo);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Tipo> getTiposByCategoria(@PathVariable Integer idCategoria) {
        return tipoService.selectByCategoriaPrimaryKey(idCategoria);
    }

    @PostMapping
    public int createTipo(@RequestBody Tipo tipo) {
        return tipoService.insertSelective(tipo);
    }

    @PutMapping("/{id}")
    public int updateTipo(@PathVariable String id, @RequestBody Tipo tipo) {
        tipo.setCodTipo(id);
        return tipoService.updateByPrimaryKeySelective(tipo);
    }

    @DeleteMapping("/{id}")
    public int deleteTipo(@PathVariable String id) {
        return tipoService.deleteByPrimaryKey(id);
    }
    
}

