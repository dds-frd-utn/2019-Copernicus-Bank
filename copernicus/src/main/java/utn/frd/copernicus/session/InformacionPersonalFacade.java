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
import utn.frd.copernicus.entity.InformacionPersonal;

/**
 *
 * @author Evelyn
 */
@Stateless
public class InformacionPersonalFacade extends AbstractFacade<InformacionPersonal> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformacionPersonalFacade() {
        super(InformacionPersonal.class);
    }
    
    public List<InformacionPersonal> findByIdClienteLista(long id) {
        return em.createNamedQuery("InformacionPersonal.findByIdCliente").setParameter("idCliente", id).getResultList();
    }
}
