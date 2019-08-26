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
import utn.frd.copernicus.entity.Cliente;
import utn.frd.copernicus.entity.InformacionPersonal;
import utn.frd.copernicus.session.ClienteFacade;

/**
 *
 * @author Evelyn
 */
@Stateless
@Path("/cliente")
public class ClienteFacadeREST {

    @EJB
    private ClienteFacade ejbClienteFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Cliente cliente) {
        ejbClienteFacade.create(cliente);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Cliente cliente) {
        ejbClienteFacade.edit(cliente);
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public void remove(@PathParam("id") Long id) {
        ejbClienteFacade.remove(ejbClienteFacade.find(id));
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") Long id) {
        return ejbClienteFacade.find(id);
    }
    
    @GET
    @Path("/estadoCrediticio/{estadoCrediticio}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> clientePorEstado(
            @PathParam("estadoCrediticio")int estado) {
        return ejbClienteFacade.clienteSegunEstado(estado);
    }
    
    @GET
    @Path("/du/{documentoUnico}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> clientePorDoc(
            @PathParam("documentoUnico")long du) {
        return ejbClienteFacade.clienteSegunDU(du);
    }
    
    @GET
    @Path("/{idCliente}/informacionPersonal")
    @Produces({MediaType.APPLICATION_JSON})
    public List<InformacionPersonal> findByIdCliente(@PathParam("idCliente")long id) {
        return ejbClienteFacade.findByIdClienteLista(id);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return ejbClienteFacade.findAll();
    }
    
}
