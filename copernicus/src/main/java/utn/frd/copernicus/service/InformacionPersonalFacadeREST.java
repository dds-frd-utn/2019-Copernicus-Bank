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
import utn.frd.copernicus.entity.InformacionPersonal;
import utn.frd.copernicus.session.InformacionPersonalFacade;
/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/informacionPersonal")
public class InformacionPersonalFacadeREST {

    @EJB
    private InformacionPersonalFacade ejbInformacionPersonalFacade;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(InformacionPersonal ip) {
        ejbInformacionPersonalFacade.create(ip);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, InformacionPersonal ip) {
        ejbInformacionPersonalFacade.edit(ip);
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void remove(@PathParam("id") Long id) {
        ejbInformacionPersonalFacade.remove(ejbInformacionPersonalFacade.find(id));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public InformacionPersonal find(@PathParam("id") Long id) {
        return ejbInformacionPersonalFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformacionPersonal> findAll() {
        return ejbInformacionPersonalFacade.findAll();
    }
    
    @GET
    @Path("/cliente/{idCliente}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformacionPersonal> findByIdCliente(@PathParam("idCliente")long id) {
        return ejbInformacionPersonalFacade.findByIdClienteLista(id);
    }
}
