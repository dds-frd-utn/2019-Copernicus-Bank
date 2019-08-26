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
import utn.frd.copernicus.entity.TipoMovimiento;
import utn.frd.copernicus.session.TipoMovimientoFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/tipo")
public class TipoMovimientoFacadeREST  {

    @EJB
    private TipoMovimientoFacade ejbTipoMovimientoFacade;

    @GET
    @Path("{idTipo}")
    @Produces({MediaType.APPLICATION_JSON})
    public TipoMovimiento find(@PathParam("idTipo") Integer id) {
        return ejbTipoMovimientoFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoMovimiento> findAll() {
        return ejbTipoMovimientoFacade.findAll();
    }
}