/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.implementation;

import com.Inventario.ApiRest.entities.Cargos;
import com.Inventario.ApiRest.repository.CargosRepository;
import com.Inventario.ApiRest.services.interfaces.ICargosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Flia Moreno Rivera
 */
@Component
public class CargosImplement implements ICargosService{
    
    @Autowired
    private CargosRepository cargosRepository;

    @Override
    public List<Cargos> findAll() {
        
        Iterable<Cargos> cargo =this.cargosRepository.findAll();
        
        return (List<Cargos>) cargo;
    }

}
