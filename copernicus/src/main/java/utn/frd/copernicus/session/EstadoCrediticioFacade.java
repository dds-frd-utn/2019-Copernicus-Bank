/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.copernicus.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.copernicus.entity.EstadoCrediticio;

/**
 *
 * @author Evelyn
 */
@Stateless
public class EstadoCrediticioFacade extends AbstractFacade<EstadoCrediticio> {

    @PersistenceContext(unitName = "utn.frd_copernicus_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCrediticioFacade() {
        super(EstadoCrediticio.class);
    }
    
}
