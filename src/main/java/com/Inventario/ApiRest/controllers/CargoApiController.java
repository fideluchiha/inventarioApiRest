/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.controllers;

import com.Inventario.ApiRest.entities.Cargos;
import com.Inventario.ApiRest.services.interfaces.ICargosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Flia Moreno Rivera
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/inventario/cargos")
public class CargoApiController {
    
    @Autowired
    private ICargosService iCargosService;
    
     @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> CargosAll() {
        
        return  ResponseEntity.ok((List<Cargos>) this.iCargosService.findAll());
    
    }
    
}
