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
import utn.frd.copernicus.entity.Bono;

/**
 *
 * @author Evelyn
 */
@Stateless
public class BonoFacade extends AbstractFacade<Bono> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonoFacade() {
        super(Bono.class);
    }
    
    public List<Bono> findByIdMovimiento(long id){
        return em.createNamedQuery("Bono.findByIdMovimiento",Bono.class).setParameter("idMovimiento",id).getResultList();
    }    
}
