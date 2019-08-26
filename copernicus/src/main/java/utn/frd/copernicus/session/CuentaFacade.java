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
import utn.frd.copernicus.entity.Cuenta;
import utn.frd.copernicus.entity.Movimiento;

/**
 *
 * @author Evelyn
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    public List<Cuenta> cuentasidCliente(int id) {
        return em.createNamedQuery("Cuenta.findByIdCliente").setParameter("idCliente", id).getResultList();
    }

    public double findSaldo(double id){
        return (double) em.createNamedQuery("Cuenta.findSaldo").setParameter("idCuenta", id).getSingleResult();
    }
    
    public List<Movimiento> findByMovimientoPorCuenta(long id){
        return em.createNamedQuery("Movimiento.findByIdCuenta",Movimiento.class).setParameter("idCuenta",id).setMaxResults(20).getResultList();
    }
    
    public List<Movimiento> movimientosSegunTyE(long id,int tipo,int estado) {
       return em.createNamedQuery("Movimiento.findByIdCuentaTyE").setParameter("idCuenta", id).setParameter("tipo", tipo).setParameter("estado", estado).setMaxResults(20).getResultList();
    }
}
