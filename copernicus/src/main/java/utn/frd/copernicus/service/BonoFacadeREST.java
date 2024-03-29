/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.copernicus.entity.Bono;
import utn.frd.copernicus.session.BonoFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/movimiento/bonos")
public class BonoFacadeREST {

    @EJB
    private BonoFacade ejbBonoFacade;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Bono bono) {
        ejbBonoFacade.create(bono);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Bono bono) {
        ejbBonoFacade.edit(bono);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") Long id) {
        ejbBonoFacade.remove(ejbBonoFacade.find(id));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bono find(@PathParam("id") Long id) {
        return ejbBonoFacade.find(id);
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bono> findAll() {
        return ejbBonoFacade.findAll();
    }
    
}
