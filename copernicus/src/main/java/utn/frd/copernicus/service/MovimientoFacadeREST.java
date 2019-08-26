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
import utn.frd.copernicus.entity.Movimiento;
import utn.frd.copernicus.session.MovimientoFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/movimientos")
public class MovimientoFacadeREST {
    
    @EJB
    private MovimientoFacade ejbMovimientoFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movimiento movimiento){
        ejbMovimientoFacade.create(movimiento);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Movimiento movimiento){
        ejbMovimientoFacade.edit(movimiento);
    }
    
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbMovimientoFacade.remove( ejbMovimientoFacade.find(id) );
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findAll() {
        return ejbMovimientoFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Movimiento findById(@PathParam("id") int id) {
        return ejbMovimientoFacade.find(id);
    }
    
    @GET
    @Path("/cuenta/{idCuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findById(@PathParam("idCuenta")long id){
        return ejbMovimientoFacade.findByIdCuenta(id);
    }
    
    @GET
    @Path("/{id}/saldo")
    @Produces({MediaType.APPLICATION_JSON})
    public Object getSaldos(@PathParam("id")double id){
        return ejbMovimientoFacade.findSaldo(id);
    }
    
    @GET
    @Path("/tipo/{tipo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> movimientoPorTipo(
            @PathParam("tipo")int tipo) {
        return ejbMovimientoFacade.movimientosSegunTipo(tipo);
    }
    
    @GET
    @Path("/estado/{estado}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> movimientoPorEstado(
            @PathParam("estado")int estado) {
        return ejbMovimientoFacade.movimientosSegunEstado(estado);
    }
    
    @GET
    @Path("/tipo/{tipo}/estado/{estado}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> movimientoPorTipoyEstado(
            @PathParam("tipo")int tipo,
            @PathParam("estado")int estado) {
        return ejbMovimientoFacade.movimientosSegunTipoEstado(tipo,estado);
    }

}