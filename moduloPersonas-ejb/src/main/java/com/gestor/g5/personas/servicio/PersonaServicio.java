/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.servicio;

import com.gestor.g5.personas.dao.PersonaDAO;
import com.gestor.g5.personas.modelo.Direccion;
import com.gestor.g5.personas.modelo.Persona;
import com.gestor.nosql.mongo.MongoPersistence;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@Stateless
@LocalBean
public class PersonaServicio {
    
    @EJB
    private MongoPersistence mp;
    
    private PersonaDAO personaDAO;
    
    @PostConstruct
    private void postConstruct() {
        this.personaDAO = new PersonaDAO(Persona.class, this.mp.context());
    }
    
    public void crearPersona(Persona persona) {
        this.personaDAO.save(persona);
    }
    
    public void actualizarPersona(Persona persona) {
        this.personaDAO.save(persona);
    }
    
    public Persona obtener(String id) {
        return this.personaDAO.findById(id);
    }
    
    public Persona obtenerPorCedula(String cedula) {
        return this.personaDAO.findByCedula(cedula);
    }
    
    public List<Persona> obtenerTodos() {
        return this.personaDAO.findAll();
    }
    
    public void actualizarDireccionDomicilio(String cedula, String calle, String numero) {
        Persona persona = this.personaDAO.findByCedula(cedula);
        if (persona!=null) {
            for (Direccion d : persona.getDireccion()) {
                if ("DOM".equals(d.getTipo())) {
                    d.setCalle(calle);
                    d.setNumero(numero);
                    this.personaDAO.save(persona);
                }
            }
        }
    }
    
}
