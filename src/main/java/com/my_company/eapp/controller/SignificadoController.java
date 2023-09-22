/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.my_company.eapp.controller;

import com.my_company.eapp.model.Significado;
import com.my_company.eapp.services.SignificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/significados")
//@RequestMapping(value = "/significados", method = { RequestMethod.GET, RequestMethod.POST })
public class SignificadoController {

    private final SignificadoService significadoService;

    @Autowired
    public SignificadoController(SignificadoService significadoService) {
        this.significadoService = significadoService;
    }

    @GetMapping
    public List<Significado> getAllSignificados() {
        return significadoService.getAllSignificados();
    }

    @GetMapping("/{id}")
    public Significado getSignificadoById(@PathVariable Integer id) {
        return significadoService.getSignificadoById(id);
    }

    @PostMapping
    public int createSignificado(@RequestBody Significado significado) {
        return significadoService.createSignificado(significado);
    }

    @PutMapping("/{id}")
    public int updateSignificado(@PathVariable Integer id, @RequestBody Significado significado) {
        significado.setIdSignificado(id);
        return significadoService.updateSignificado(significado);
    }

    @DeleteMapping("/{id}")
    public int deleteSignificado(@PathVariable Integer id) {
        return significadoService.deleteSignificado(id);
    }

    @GetMapping("/palabra/{idPalabraFrase}")
    public List<Significado> getSignificadosByPalabraFraseId(@PathVariable Integer idPalabraFrase) {
        System.out.println("Retorna: " + significadoService.selectByPalabraFrasePrimaryKey(idPalabraFrase));
        return significadoService.selectByPalabraFrasePrimaryKey(idPalabraFrase);
    }

}
