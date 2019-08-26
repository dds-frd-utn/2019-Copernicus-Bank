/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.copernicus.entity.EstadoCrediticio;
import utn.frd.copernicus.session.EstadoCrediticioFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/estadoCrediticio")
public class EstadoCrediticioFacadeREST {
    
    @EJB
    private EstadoCrediticioFacade ejbEstadoCrediticioFacade;

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EstadoCrediticio find(@PathParam("id") Long id) {
        return ejbEstadoCrediticioFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoCrediticio> findAll() {
        return ejbEstadoCrediticioFacade.findAll();
    }
    
}
