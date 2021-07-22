/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.controllers;

import com.Inventario.ApiRest.entities.Productos;
import com.Inventario.ApiRest.services.interfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Flia Moreno Rivera
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/inventario/productos")
public class ProductoApiController {
    
    @Autowired
    private IProductosService iProductosService;
    
    @GetMapping(value ="/prueba", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> prueba() {
        
        return  ResponseEntity.ok("prueba");
    
    }
    
    
    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> ProductosAll() {
        
        return  ResponseEntity.ok(this.iProductosService.findAll());
    
    }
        
    @PostMapping(value ="/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveProductos(@RequestBody Productos request){
        
            return this.iProductosService.save(request);
    }
        
    @GetMapping(value ="/delete/{id}/{id_usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> DeleteLocation(@PathVariable("id") Long id,@PathVariable("id_usuario") long id_usuario) {
        
        return this.iProductosService.deleteByIdProductoValUsuario(id, id_usuario);
        
        
    }
    
    
    @GetMapping(value ="/findOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findOne(@PathVariable("id") Long id) {
        
        return ResponseEntity.ok(this.iProductosService.findById(id));
        
        
    }
    
    
    @PostMapping(value ="/edit", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> editProductos(@RequestBody Productos request){
        
            return this.iProductosService.edit(request);
    }
}
