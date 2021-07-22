/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author Flia Moreno Rivera
 */
@Data
public class UsersRequest {
    
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("identificacion")
    private String identificacion;
    @JsonProperty("username")
    private String username;
    @JsonProperty("clave")
    private String clave;
    @JsonProperty("id_cargo")
    private Long id_cargo;
}
