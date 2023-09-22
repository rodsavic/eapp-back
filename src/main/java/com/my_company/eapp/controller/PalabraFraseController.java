package com.my_company.eapp.controller;

import com.my_company.eapp.dao.PalabraFraseMapper;
import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample;
import com.my_company.eapp.services.PalabraFraseService;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/palabrafrases")
public class PalabraFraseController {

    private final PalabraFraseService palabraFraseService;

    @Autowired
    public PalabraFraseController(PalabraFraseService palabraFraseService) {
        this.palabraFraseService = palabraFraseService;
    }

    @GetMapping
    public List<PalabraFrase> getAllPalabrasFrases() {
        return palabraFraseService.getAllPalabrasFrases();
    }

    @GetMapping("/{id}")
    public PalabraFrase getPalabraFraseById(@PathVariable Integer id) {
        return palabraFraseService.getPalabraFraseById(id);
    }

    @PostMapping
    public int createPalabraFrase(@RequestBody PalabraFrase palabraFrase) {
        return palabraFraseService.createPalabraFrase(palabraFrase);
    }

    @PutMapping("/{id}")
    public int updatePalabraFrase(@PathVariable Integer id, @RequestBody PalabraFrase palabraFrase) {
        return palabraFraseService.updatePalabraFrase(id, palabraFrase);
    }

    @DeleteMapping("/{id}")
    public int deletePalabraFrase(@PathVariable Integer id) {
        return palabraFraseService.deletePalabraFrase(id);
    }

    @GetMapping("/buscarPorContenido/{contenido}")
    public Integer getPalabraFraseIdByContenido(@PathVariable String contenido) {
        return palabraFraseService.getPalabraFraseIdByContenido(contenido);
    }

    @GetMapping("/buscar")
    public List<PalabraFrase> buscarPalabrasConFiltros(
            @RequestParam(name = "contenido", required = false) String contenido,
            @RequestParam(name = "dificultad", required = false) String dificultad,
            @RequestParam(name = "aprendido", required = false) Boolean aprendido,
            @RequestParam(name = "codTipo", required = false) String codTipo,
            @RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(name = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        // Construye el objeto PalabraFraseExample
        PalabraFraseExample example = new PalabraFraseExample();
        PalabraFraseExample.Criteria criteria = example.createCriteria();
        System.out.println("Ingresa al controlador de PalabraFrase - buscarPalabrasConFiltros");
        // Aplica los filtros según los parámetros proporcionados
        if (contenido != null && !contenido.isEmpty()) {
            criteria.andContenidoLike("%" + contenido + "%");
        }

        if (dificultad != null && Arrays.asList("Easy", "Medium", "Hard").contains(dificultad)) {
            criteria.andDificultadEqualTo(dificultad);
        }

        if (aprendido != null) {
            criteria.andAprendidoEqualTo(aprendido);
        }

        if (codTipo != null) {
            System.out.println("codTipo: " + codTipo);
            criteria.andCodTipoEqualTo(codTipo);
        } else {
            System.out.println("codTipo es null");
        }

        if (fechaInicio != null && fechaFin != null) {
            criteria.andFechaRegistroBetween(fechaInicio, fechaFin);
        }

        // Llama al método de búsqueda en el servicio
        return palabraFraseService.buscarPalabrasConFiltros(example);
    }
}
