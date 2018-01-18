/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.g5.personas.api;

import com.gestor.g5.personas.api.messages.PersonaRQ;
import com.gestor.g5.personas.modelo.Persona;
import com.gestor.g5.personas.servicio.PersonaServicio;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Hendrix
 */
@Path("persona")
@RequestScoped
public class PersonaResource {

    @Context
    private UriInfo context;

    @Inject
    private PersonaServicio personaServicio;

    /**
     * Creates a new instance of PersonaResource
     */
    public PersonaResource() {
    }

    /**
     * Retrieves representation of an instance of com.gestor.g5.personas.api.PersonaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        try {
            List<Persona> personas = this.personaServicio.obtenerTodos();
            GenericEntity generic = new GenericEntity<List<Persona>>(personas) {
            };
            return Response.ok(generic).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error no hay base: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("id") String id) {
        try {
            Persona persona = this.personaServicio.obtenerPorCedula(id);
            if (persona!=null) {
                return Response.ok(persona).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error no hay base: " + e.getMessage()).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of PersonaResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(PersonaRQ content) {
        try {
            Persona persona = new Persona();
            persona.setCedula(content.getCedula());
            persona.setNombre(content.getNombre());
            this.personaServicio.crearPersona(persona);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Cedula duplicada " + e.getMessage()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(PersonaRQ content) {
        try {
            Persona persona = this.personaServicio.obtenerPorCedula(content.getCedula());
            if (persona!=null) {
                if (content.getNombre()!=null) {
                    persona.setNombre(content.getNombre());
                }
                this.personaServicio.actualizarPersona(persona);
            }
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Cedula duplicada " + e.getMessage()).build();
        }
    }
}
