/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.api.messages;

import com.gestor.g5.personas.modelo.Direccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hendrix
 */
public class PersonaRQ {
    
    private String cedula;
    private String nombre;
    
    public PersonaRQ() {
       
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    
}
