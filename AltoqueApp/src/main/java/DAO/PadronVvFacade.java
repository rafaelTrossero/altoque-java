/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class PadronVvFacade extends AbstractFacade<PadronVv> implements PadronVvFacadeLocal {

    @PersistenceContext(name = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PadronVvFacade() {
        super(PadronVv.class);
    }

    @Override
    public PadronVv findByDni(Integer dni) {
        try {

            Query q = em.createNamedQuery("PadronVv.findByDni");
            q.setParameter("dni", dni);

            return (PadronVv) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PadronVv> findByApenom(String apenom) {
        try {

            Query q = em.createNamedQuery("PadronVv.findByApenom");
            q.setParameter("apenom", "%" + apenom + "%");
            //q.setParameter("apenom", apenom.toLowerCase());
           
            return (List<PadronVv>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PadronVv> findByOrden(Integer orden) {
        try {

            Query q = em.createNamedQuery("PadronVv.findByOrden");
            q.setParameter("orden", orden);

            return (List<PadronVv>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PadronVv> findByDniList(Integer dni) {
        try {

            Query q = em.createNamedQuery("PadronVv.findByDni");
            q.setParameter("dni", dni);

            return (List<PadronVv>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void editVinculado(PadronVv padronVv) {
        try {

            Query q = em.createNamedQuery("PadronVv.editVinculado");
            q.setParameter("id", padronVv.getId());

            q.executeUpdate();

        } catch (Exception e) {

        }
    }

    @Override
    public List<PadronVv> findByAuto(Car car) {
        try {

            Query q = em.createNamedQuery("PadronVv.findByAuto");
            q.setParameter("car", car);

            return (List<PadronVv>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
