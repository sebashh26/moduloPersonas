/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.api;

import com.gestor.g5.personas.api.messages.PersonaDireccionRQ;
import com.gestor.g5.personas.modelo.Direccion;
import com.gestor.g5.personas.modelo.Persona;
import com.gestor.g5.personas.servicio.PersonaServicio;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Hendrix
 */
@Path("actualizaDireccionPersona")
@RequestScoped
public class ActualizaDireccionPersonaResource {
    
    @Context
    private UriInfo context;
    @Inject
    private PersonaServicio personaServicio;

    /**
     * Creates a new instance of ActualizaDireccionPersonaResource
     */
    public ActualizaDireccionPersonaResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.gestor.g5.personas.api.ActualizaDireccionPersonaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ActualizaDireccionPersonaResource
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(PersonaDireccionRQ content) {
        Persona per = this.personaServicio.obtenerPorCedula(content.getCedula());
        boolean agregar = true;
        for (Direccion d : per.getDireccion()) {
            if (d.getTipo().equals(content.getTipo())) {
                d.setBarrio(content.getBarrio());
                d.setCalle(content.getCalle());
                d.setInterseccion(content.getInterseccion());
                d.setNumero(content.getNumero());
                agregar=false;
            }
        }
        if (agregar) {
            Direccion d = new Direccion();
            d.setBarrio(content.getBarrio());
            d.setCalle(content.getCalle());
            d.setInterseccion(content.getInterseccion());
            d.setNumero(content.getNumero());
            d.setTipo(content.getTipo());
            per.getDireccion().add(d);
        }
        this.personaServicio.actualizarPersona(per);
        return Response.ok(per).build();
    }
}
