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
import utn.frd.copernicus.entity.Transferencia;
import utn.frd.copernicus.session.TransferenciaFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/movimiento/transferencias")
public class TransferenciaFacadeREST {

    @EJB
    private TransferenciaFacade ejbTransferenciaFacade;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Transferencia transferencia) {
        ejbTransferenciaFacade.create(transferencia);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Transferencia transferencia) {
        ejbTransferenciaFacade.edit(transferencia);
    }
    
    @PUT
    @Path("/entrantes")
    @Consumes({MediaType.APPLICATION_JSON})
    public void transferenciaEntrante(Transferencia transferencia){
        ejbTransferenciaFacade.create(transferencia);
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void remove(@PathParam("id") Long id) {
        ejbTransferenciaFacade.remove(ejbTransferenciaFacade.find(id));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Transferencia find(@PathParam("id") Long id) {
        return ejbTransferenciaFacade.find(id);
    }
    
    @GET
    @Path("/{idMovimiento}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transferencia> findById(@PathParam("idMovimiento")long id){
        return ejbTransferenciaFacade.findByIdMovimiento(id);
    }

    @GET
    @Path("/{idTransferencia}/saldo")
    @Produces({MediaType.APPLICATION_JSON})
    public double getSaldos(@PathParam("idTransferencia") Long id){
        return ejbTransferenciaFacade.findSaldo(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transferencia> findAll() {
        return ejbTransferenciaFacade.findAll();
    }
    
}
