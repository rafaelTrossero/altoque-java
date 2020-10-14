/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.MesaDistrito;
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
public class MesaDistritoFacade extends AbstractFacade<MesaDistrito> implements MesaDistritoFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesaDistritoFacade() {
        super(MesaDistrito.class);
    }

    @Override
    public MesaDistrito findByMesa(Integer mesa) {
    try {
           
            Query q = em.createNamedQuery("MesaDistrito.findByMesa");
            q.setParameter("mesa", mesa);
          
            return (MesaDistrito) q.getSingleResult();
            
        } catch (Exception e) {
            return null;
        }  }

    @Override
    public List<MesaDistrito> findByDistrito(String distrito) {
  
     try {
            Query q = em.createNamedQuery("MesaDistrito.findByDistrito");
            q.setParameter("distrito", distrito);
            

            return (List<MesaDistrito>) q.getResultList();

        } catch (Exception e) {
            return null;
        }  
    }  
    
}
