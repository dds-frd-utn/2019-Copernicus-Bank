/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.copernicus.entity.Movimiento;
/**
 *
 * @author Evelyn
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }
    
    public List<Movimiento> findByIdCuenta(long id){
        return em.createNamedQuery("Movimiento.findByIdCuenta",Movimiento.class).setParameter("idCuenta",id).getResultList();
    }

    public Object findSaldo(double id){
        return em.createNamedQuery("Movimiento.findImporte", Movimiento.class).setParameter("id", id).getSingleResult();
    }
    
    public List<Movimiento> findByUltimosDeCuenta(long id){
        return em.createNamedQuery("Movimiento.findByIdCuenta",Movimiento.class).setParameter("idCuenta",id).setMaxResults(30).getResultList();
    }
    
    public List<Movimiento> movimientosSegunEstado(int estado) {
        return em.createNamedQuery("Movimiento.findByEstado").setParameter("estado", estado).getResultList();
    }

    public List<Movimiento> movimientosSegunTipo(int tipo) {
       return em.createNamedQuery("Movimiento.findByTipo").setParameter("tipo", tipo).getResultList();
    }
    
    public List<Movimiento> movimientosSegunTipoEstado(int tipo, int estado) {
       return em.createNamedQuery("Movimiento.findByTyE").setParameter("estado", estado).setParameter("tipo", tipo).getResultList();
    }

}
