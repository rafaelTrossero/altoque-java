/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Locacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rat_5
 */
@Stateless
public class LocacionFacade extends AbstractFacade<Locacion> implements LocacionFacadeLocal {

    @PersistenceContext(unitName = "roi_altoquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocacionFacade() {
        super(Locacion.class);
    }
    
}
