/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.repository;

import com.Inventario.ApiRest.entities.Cargos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flia Moreno Rivera
 */
@Repository
public interface CargosRepository extends CrudRepository<Cargos, Long >{
    
}
