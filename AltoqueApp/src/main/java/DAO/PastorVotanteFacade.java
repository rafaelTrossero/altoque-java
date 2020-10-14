/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorVotante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class PastorVotanteFacade extends AbstractFacade<PastorVotante> implements PastorVotanteFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PastorVotanteFacade() {
        super(PastorVotante.class);
    }

    @Override
    public List<PadronVv> findVotantesByPastor(Pastor pastor) {
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createNamedQuery("PastorVotante.findVotantesByPastor");
        q.setParameter("pastor", pastor);
        return q.getResultList();
    }

    @Override
    public void removeByPastor(Pastor pastor) {
        Query q = em.createNamedQuery("PastorVotante.removeByPastor");
        q.setParameter("pastor", pastor);
        q.executeUpdate();

    }

    @Override
    public List<PastorVotante> findByVotanteYpastor(Pastor pastor, PadronVv votante) {
        em.getEntityManagerFactory().getCache().evictAll();

        Query q = em.createNamedQuery("PastorVotante.findByVotanteYpastor");
        q.setParameter("pastor", pastor);
        q.setParameter("votante", votante);
        return q.getResultList();

    }

}
