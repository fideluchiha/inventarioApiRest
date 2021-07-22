/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inventario.ApiRest.utils;

import org.modelmapper.ModelMapper;

/**
 *
 * @author Flia Moreno Rivera
 */
public class MHelpers {
    
    public static ModelMapper modelMapper(){
    
        return new ModelMapper();
    }
}
