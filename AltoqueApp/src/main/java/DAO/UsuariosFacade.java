/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vouilloz
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios findUserByNombreContrasena(String nombre, String contrasena) {
        try {
           
            Query q = em.createNamedQuery("Usuarios.findUserByNombreContrasena");
            q.setParameter("usuario", nombre);
            q.setParameter("contrasena", contrasena);
            
            em.getEntityManagerFactory().getCache().evictAll();
            return (Usuarios) q.getSingleResult();
            
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuarios findById(Integer id) {
    try {
           
            Query q = em.createNamedQuery("Usuarios.findById");
            q.setParameter("id", id);
           
            
            return (Usuarios) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> findAllActive() {
       try {
            Query q = em.createNamedQuery("Usuarios.findAllActive");

            return (List<Usuarios>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

}
