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
import utn.frd.copernicus.entity.Transferencia;

/**
 *
 * @author Evelyn
 */
@Stateless
public class TransferenciaFacade extends AbstractFacade<Transferencia> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransferenciaFacade() {
        super(Transferencia.class);
    }

    public List<Transferencia> findByIdMovimiento(long id){
        return em.createNamedQuery("Transferencia.findByIdMovimiento",Transferencia.class).setParameter("idMovimiento",id).getResultList();
    }
    
    public double findSaldo(double id){
        return (double) em.createNamedQuery("Transferencia.findImporte").setParameter("idTransferencia", id).getSingleResult();
    }
    
}
