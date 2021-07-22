/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Flia Moreno Rivera
 */
@Data
public class UsersDTO implements Serializable{
    
    
    private String id;
    private String nombre;
    private String username;
    private Date createdAt;
    private Date updatedAt;
}
