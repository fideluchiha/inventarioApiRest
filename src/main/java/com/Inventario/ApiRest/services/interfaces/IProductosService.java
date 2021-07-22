/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.interfaces;

import com.Inventario.ApiRest.entities.Productos;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flia Moreno Rivera
 */
@Service
public interface IProductosService {
    
    List<Productos> findAll();
    
    Optional<Productos> findByNombreProducto(String producto);
    
    ResponseEntity<Object> save(Productos producto);
    
    ResponseEntity<Object> deleteByIdProductoValUsuario(Long id,long id_usuario);
    
    ResponseEntity<Object> edit(Productos producto);
    
    Optional<Productos> findById(Long id);
}
