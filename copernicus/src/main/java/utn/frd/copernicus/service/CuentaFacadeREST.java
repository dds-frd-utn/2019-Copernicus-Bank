/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.copernicus.entity.Cuenta;
import utn.frd.copernicus.entity.Movimiento;
import utn.frd.copernicus.session.CuentaFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/cuenta")
public class CuentaFacadeREST {

    @EJB
    private CuentaFacade ejbCuentaFacade;
    

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Cuenta cuenta) {
        ejbCuentaFacade.create(cuenta);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Cuenta cuenta) {
        ejbCuentaFacade.edit(cuenta);
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void remove(@PathParam("id") Long id) {
        ejbCuentaFacade.remove(ejbCuentaFacade.find(id));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cuenta find(@PathParam("id") Long id) {
        return ejbCuentaFacade.find(id);
    }
    
    @GET
    @Path("/cliente/{idCliente}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cuenta> findByIdCliente(@PathParam("idCliente")int id){
        return ejbCuentaFacade.cuentasidCliente(id);
    }
    
    @GET
    @Path("/{idCuenta}/saldo")
    @Produces({MediaType.APPLICATION_JSON})
    public Object getSaldos(@PathParam("idCuenta")int id){
        return ejbCuentaFacade.findSaldo(id);
    }
    
    @GET
    @Path("/{idCuenta}/ultimosMovimientos")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> getMovimientos(
            @PathParam("idCuenta")int id){
        return ejbCuentaFacade.findByMovimientoPorCuenta(id);
    }

    @GET
    @Path("/{idCuenta}/movimientos/tipo/{tipo}/estado/{estado}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> movimientoPorTipoyEstado(
            @PathParam("idCuenta")long id,
            @PathParam("tipo")int tipo,
            @PathParam("estado")int estado){
        return ejbCuentaFacade.movimientosSegunTyE(id,tipo,estado);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cuenta> findAll() {
        return ejbCuentaFacade.findAll();
    }
    
}
