/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.services.implementation;

import com.Inventario.ApiRest.dto.UsersDTO;
import com.Inventario.ApiRest.dto.UsersRequest;
import com.Inventario.ApiRest.entities.Users;
import com.Inventario.ApiRest.repository.UsersRepository;
import com.Inventario.ApiRest.services.interfaces.IUsersService;
import com.Inventario.ApiRest.utils.MHelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Flia Moreno Rivera
 */
@Component
public class UsersImplement implements IUsersService{
    
    @Autowired
    private UsersRepository userRepository;
    
    
    @Override
    public List<UsersDTO> findAll() {
        
        List<UsersDTO> dto = new ArrayList<>();
        Iterable<Users> users = this.userRepository.findAll();
        
        for (Users user : users) {
            UsersDTO usersDTO = MHelpers.modelMapper().map(user, UsersDTO.class);
            dto.add(usersDTO);
        }
        
        return dto;
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Optional<Users> findByIdentificacion(int identificacion ) {
        
        Optional<Users> users = this.userRepository.findByIdentificacion(identificacion);
        
        return users;
        
    }

    @Override
    public ResponseEntity<Object> save(UsersRequest user) {
        try {
            
            Optional<Users> users = this.userRepository.findByIdentificacion(Integer.parseInt(user.getIdentificacion()));
            
            if ( users.isPresent()) {
                
                return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"Usuario ya existe con la misma identificacion  \"}");
            }else{
                Users usuario =MHelpers.modelMapper().map(user, Users.class);
                usuario.setId(null);
                this.userRepository.save(usuario);

                return ResponseEntity.ok("{\"succes\":\"Registro Existoso!!!  \"}");
            }
            }
        catch (MappingException  exc ) {
            
            
            return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"error de mapeo de objeto "+exc.getMessage()+"  \"}");
            
            
        }
      
    }
    
    public ResponseEntity<Object> findByUsernameAndClave(String username, String clave ){
    
          Optional<Users> user =  this.userRepository.findByUsernameAndClave(username, clave);
          if ( user.get().getId() > 0) {
                
              return ResponseEntity.ok("{\"succes\":\"login valido!!!  \"}");
                
            }else{
                
              return ResponseEntity.status(400).body("{\n" +
                "    \"error\":\"Credenciales invalidas  \"}");
                
            }
    
    }

    @Override
    public void deleteById(long id) {
         this.userRepository.deleteById(id);
    }
    
    private UsersDTO converToUsersDTO(final Users users){
    
        return  MHelpers.modelMapper().map(users, UsersDTO.class);
    }
}
