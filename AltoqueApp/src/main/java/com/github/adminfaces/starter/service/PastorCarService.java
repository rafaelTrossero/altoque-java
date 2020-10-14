/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.PastorCarFacadeLocal;
import DAO.PastorVotanteFacadeLocal;
import com.github.adminfaces.starter.model.PastorCar;
import com.github.adminfaces.starter.model.PastorVotante;
import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rat_5
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class PastorCarService {

  
    List<PastorCar> allPastorCar;

    @EJB
    private PastorCarFacadeLocal pastorCarFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public List<PastorCar> getAllPastorCar() {
        return allPastorCar;
    }

    public void setAllPastorCar(List<PastorCar> allPastorCar) {
        this.allPastorCar = allPastorCar;
    }

    public PastorCarFacadeLocal getPastorCarFacadeLocal() {
        return pastorCarFacadeLocal;
    }

    public void setPastorCarFacadeLocal(PastorCarFacadeLocal pastorCarFacadeLocal) {
        this.pastorCarFacadeLocal = pastorCarFacadeLocal;
    }

  
    @RolesAllowed("ADMIN")
    public void insert(PastorCar pastorCar) {
        try {
            //validate(pastorVotante);

           // allPastorVotante.add(pastorVotante);
             System.out.println("PastorCar"+pastorCar);
            pastorCarFacadeLocal.create(pastorCar);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @RolesAllowed("ADMIN")
    public void remove(PastorCar pastorCar) {
        this.pastorCarFacadeLocal.remove(pastorCar);
        allPastorCar.remove(pastorCar);

    }

  
    @RolesAllowed("ADMIN")
    public void update(PastorCar pastorCar) {
       // validate(pastorVotante);
        allPastorCar.remove(allPastorCar.indexOf(pastorCar));
        allPastorCar.add(pastorCar);
        pastorCarFacadeLocal.edit(pastorCar);

    }

   
    
}
