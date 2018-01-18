/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.api.messages;

/**
 *
 * @author Hendrix
 */
public class PersonaRS {
    
    private String cedula;
    private String nombre;
    private String fechaRegistro;
    
    public PersonaRS() {
        
    }

    public PersonaRS(String cedula, String nombre, String fechaRegistro) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
