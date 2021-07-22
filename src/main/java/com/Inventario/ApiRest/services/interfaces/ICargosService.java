/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.interfaces;

import com.Inventario.ApiRest.entities.Cargos;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flia Moreno Rivera
 */
@Service
public interface ICargosService {
    
    List<Cargos> findAll();
}
