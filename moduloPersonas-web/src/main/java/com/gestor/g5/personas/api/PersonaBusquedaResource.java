/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.api;

import com.gestor.g5.personas.api.messages.PersonaRS;
import com.gestor.g5.personas.modelo.Persona;
import com.gestor.g5.personas.servicio.PersonaServicio;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Hendrix
 */
@Path("personaBusqueda")
@RequestScoped
public class PersonaBusquedaResource {

    @Context
    private UriInfo context;

    @Inject
    private PersonaServicio personaServicio;

    /**
     * Creates a new instance of PersonaBusquedaResource
     */
    public PersonaBusquedaResource() {
    }

    /**
     * Retrieves representation of an instance of com.gestor.g5.personas.api.PersonaBusquedaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam(value = "inicio") Integer inicio, @QueryParam(value = "cuantos") Integer cuantos) {
        List<Persona> personas = this.personaServicio.obtenerTodos();
        List<Persona> sublista = personas.subList(inicio, inicio + cuantos);
        List<PersonaRS> respuesta = new ArrayList<>();
        for (Persona p : sublista) {
            PersonaRS rs = new PersonaRS(p.getCedula(), p.getNombre(), p.getCreationDate().toString());
            respuesta.add(rs);
        }
        
        GenericEntity generic = new GenericEntity<List<PersonaRS>>(respuesta) {
        };
        return Response.ok(generic).build();
    }

}
