/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Candidatos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rat_5
 */
@Stateless
public class CandidatosFacade extends AbstractFacade<Candidatos> implements CandidatosFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatosFacade() {
        super(Candidatos.class);
    }

    @Override
    public List<String> findCargos() {
        try {
            Query q = em.createNamedQuery("Candidatos.findCargos");

            return (List<String>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Candidatos> findBycargo(String cargo) {
        try {
            Query q = em.createNamedQuery("Candidatos.findByCargo");
            q.setParameter("cargo", cargo);
            return (List<Candidatos>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Candidatos> findAllNacionales() {
        try {
            Query q = em.createNamedQuery("Candidatos.findAllNacionales");

            return (List<Candidatos>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Candidatos> findAllProvinciales() {
        try {
            Query q = em.createNamedQuery("Candidatos.findAllProvinciales");

            return (List<Candidatos>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Candidatos> findAllByLugar(String lugar) {
        try {
            Query q = em.createNamedQuery("Candidatos.findAllByLugar");
            q.setParameter("lugar", lugar);
            

            return (List<Candidatos>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Candidatos> findAllProvincialesByLugar(String lugar) {
     try {
            Query q = em.createNamedQuery("Candidatos.findAllProvincialesByLugar");
            q.setParameter("lugar", lugar);
            

            return (List<Candidatos>) q.getResultList();

        } catch (Exception e) {
            return null;
        }  }

}
