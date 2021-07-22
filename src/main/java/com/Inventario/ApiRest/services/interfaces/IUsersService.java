/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.interfaces;

import com.Inventario.ApiRest.dto.UsersDTO;
import com.Inventario.ApiRest.dto.UsersRequest;
import com.Inventario.ApiRest.entities.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Flia Moreno Rivera
 */
@Service
public interface IUsersService {
    
    List<UsersDTO> findAll();
    
    Optional<Users> findByUsername(String username);
    
    Optional<Users> findByIdentificacion(int identificacion );
    
    ResponseEntity<Object> save(UsersRequest user);
    
    ResponseEntity<Object> findByUsernameAndClave(String username, String clave );
    
    void deleteById(long id);
}
