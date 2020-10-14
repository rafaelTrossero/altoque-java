/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Acta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rat_5
 */
@Stateless
public class ActaFacade extends AbstractFacade<Acta> implements ActaFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActaFacade() {
        super(Acta.class);
    }
    
}
