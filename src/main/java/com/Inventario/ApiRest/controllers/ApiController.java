/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.controllers;

import com.Inventario.ApiRest.dto.UsersRequest;
import com.Inventario.ApiRest.services.interfaces.IUsersService;
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
@RequestMapping("/inventario/usuarios")
//@RequestMapping("/usuarios")
public class ApiController {
    
    @Autowired
    private IUsersService iUsersService;
    
    
    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        
        return  ResponseEntity.ok(this.iUsersService.findAll());
    
    }
    
    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> DeleteUsers(@PathVariable("id") Long id) {
            
        this.iUsersService.deleteById(id);
        return ResponseEntity.ok("{\"succes\":\"Eliminado!!!  \"}");
        
        
    }
    
    @PostMapping(value ="/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUsuarios(@RequestBody UsersRequest request){
        
            return this.iUsersService.save(request);
    }
    
    
    
   
}
