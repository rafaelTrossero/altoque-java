/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import com.github.adminfaces.starter.model.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public void activate(Persona persona, Boolean bEstado) {
        Query q = em.createNamedQuery("Persona.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", persona.getId());
        // Query q = em.createQuery("UPDATE Agenda p SET p.habilitado = " + estado + " WHERE p.id = " +  id);    
         /*q.setParameter("id", id);
         q.setParameter("estado", estado);  */
        q.executeUpdate();

    }

    @Override
    public Boolean bFindByDni(Persona p, int op) throws Exception {
        Query q = null;

        if (op == 0) {
            //guardar
            q = em.createNamedQuery("Persona.findByDni");

        } else {
            //modificar
            q = em.createNamedQuery("Persona.findByDniID");
            q.setParameter("id", p.getId());

        }//fin if

        q.setParameter("dni", p.getDni());

        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }

    }

    @Override
    public Boolean bFindByCuil(Persona p, int op) throws Exception {
        Query q = null;

        if (op == 0) {
            //guardar
            q = em.createNamedQuery("Persona.findByCuil");

        } else {
            //modificar
            q = em.createNamedQuery("Persona.findByCuilID");
            q.setParameter("id", p.getId());

        }//fin if

        q.setParameter("cuil", p.getCuil());

        try {
            q.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }

    @Override
    public List<Persona> findAllActivo() {
      try {
            Query q = em.createNamedQuery("Persona.SelectAlltrue");

            q.setParameter("active", true);

            return (List<Persona>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    
    }

}
