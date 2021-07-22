/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.implementation;


import com.Inventario.ApiRest.entities.Productos;
import com.Inventario.ApiRest.repository.ProductosRepository;
import com.Inventario.ApiRest.services.interfaces.IProductosService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Flia Moreno Rivera
 */
@Component
public class ProductosImplement implements IProductosService{
    
    @Autowired
    private ProductosRepository ProductosRepository;

    @Override
    public List<Productos> findAll() {
        
        return (List<Productos>) this.ProductosRepository.findAll();
    }
    
    @Override
    public Optional<Productos> findById(Long id) {
        
        return  this.ProductosRepository.findById(id);
    }

    @Override
    public Optional<Productos> findByNombreProducto(String producto) {
        
        return this.ProductosRepository.findByNombreProducto(producto);
    }

    @Override
    public ResponseEntity<Object> save(Productos producto) {
        
        Optional<Productos> product = this.ProductosRepository.findByNombreProducto(producto.getNombreProducto());
        Date fechaActual = new Date();
        if (product.isPresent()) {
            
            return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"Producto ya existe con el mismo Nombre  \"}");
        }else if(producto.getFechaIngreso().after(fechaActual)){
           
             return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"Producto no puede ser superior a la fecha actual  \"}");
        
        }else {
            producto.setIdProducto(null);
            this.ProductosRepository.save(producto);
            return ResponseEntity.ok("{\"succes\":\"Registro Existoso!!!  \"}");
            
        }
    }
    
    
    @Override
    public ResponseEntity<Object> edit(Productos producto) {
        
        Date fechaActual = new Date();
        if(producto.getFechaIngreso().after(fechaActual)){
           
             return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"Producto no puede ser superior a la fecha actual  \"}");
        
        }else {
            this.ProductosRepository.save(producto);
            return ResponseEntity.ok("{\"succes\":\"se edito de forma Existosa!!!  \"}");
            
        }
    }

    @Override
    public ResponseEntity<Object> deleteByIdProductoValUsuario(Long id, long id_usuario) {
        
         Optional<Productos> product = this.ProductosRepository.findById(id);
        
        if (product.get().getId_usuario()== id_usuario ) {
            
            this.ProductosRepository.deleteById(id);
            return ResponseEntity.ok("{\"succes\":\"Borrado Existoso!!!  \"}");
        }else{
            
             return ResponseEntity.status(400).body("{ \"error\":\"El usuario no ingreso el producto no lo puede eliminar!!!\"}");
        
        }
    }
    
   
    

   
}
