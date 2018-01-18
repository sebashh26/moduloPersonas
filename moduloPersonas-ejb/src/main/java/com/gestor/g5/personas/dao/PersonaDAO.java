/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.dao;

import com.gestor.g5.personas.modelo.Persona;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author Hendrix
 */
public class PersonaDAO extends BasicDAO<Persona, ObjectId> {
    
    public PersonaDAO(Class<Persona> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
    
    public Persona findById(String id) {
        ObjectId objectId = new ObjectId(id);
        return super.get(objectId);
    }
    
    public Persona findByCedula(String cedula) {
        return super.findOne("cedula", cedula);
    }
    
    public List<Persona> findAll() {
        return super.find().asList();
    }
    
    public List<Persona> findByNombre(String nombre) {
        return super.find(super.createQuery().field("nombre").equal(nombre)).asList();
    }
    
    
    
    @Override
    public Key<Persona> save(Persona persona) {
        return super.save(persona);
    }
}
