/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.copernicus.entity.EstadoMovimiento;
import utn.frd.copernicus.session.EstadoMovimientoFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/estadoMovimiento")
public class EstadoMovimientoFacadeREST {

    @EJB
    private EstadoMovimientoFacade ejbEstadoMovimientoFacade;

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EstadoMovimiento find(@PathParam("id") Long id) {
        return ejbEstadoMovimientoFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoMovimiento> findAll() {
        return ejbEstadoMovimientoFacade.findAll();
    }
    
}
