/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.servicio;

import com.gestor.g5.personas.modelo.Direccion;
import com.gestor.g5.personas.modelo.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Hendrix
 */
@Singleton
@Startup
public class PruebaServicio {
    
    @EJB
    private PersonaServicio personaServicio;
    
    @PostConstruct
    private void postConstruct() {
//        Persona per = new Persona();
//        per.setCedula("1714864830");
//        per.setFechaNacimiento(new Date());
//        per.setNombre("Hendrix");
//        this.personaServicio.crearPersona(per); 
//        Persona persona = this.personaServicio.obtenerPorCedula("1714864830");
//        System.err.println("La persona creada es: "+persona.toString());
//        Direccion dir = new Direccion();
//        dir.setCalle("Augusto egas");
//        dir.setNumero("n33-65");
//        dir.setInterseccion("Bosmediano");
//        dir.setTipo("DOM");
//        List<Direccion> direcciones = new ArrayList<>();
//        direcciones.add(dir);
//        persona.setDireccion(direcciones);
//        this.personaServicio.actualizarPersona(persona);
        
    }
}
