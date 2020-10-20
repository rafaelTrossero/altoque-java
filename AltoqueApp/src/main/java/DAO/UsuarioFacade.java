/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "roi_altoquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findUserByNombreContrasena(String nombre, String contrasena) {
        try {
           
            Query q = em.createNamedQuery("Usuario.findUserByNombreContrasena");
            q.setParameter("usuario", nombre);
            q.setParameter("contrasena", contrasena);
            
            em.getEntityManagerFactory().getCache().evictAll();
            return (Usuario) q.getSingleResult();
            
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario findById(Integer id) {
    try {
           
            Query q = em.createNamedQuery("Usuario.findByIdUsuario");
            q.setParameter("id", id);
           
            
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuario> findAllActive() {
       try {
            Query q = em.createNamedQuery("Usuarios.findAllActive");

            return (List<Usuario>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

}
