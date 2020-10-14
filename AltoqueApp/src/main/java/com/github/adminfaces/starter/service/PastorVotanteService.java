/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.FiscalFacadeLocal;
import DAO.PadronVvFacadeLocal;
import DAO.PastorVotanteFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.Fiscal;
import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorVotante;
import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rat_5
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class PastorVotanteService {

    List<PastorVotante> allPastorVotante;
    List<PadronVv> lstPadronVv;
    private PadronVv votante;

    @EJB
    private PastorVotanteFacadeLocal pastorVotanteFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    @EJB
    private PadronVvFacadeLocal padronVvFacadeLocal;

    public List<PastorVotante> getAllPastorVotante() {
        return allPastorVotante;
    }

    public void setAllPastorVotante(List<PastorVotante> allPastorVotante) {
        this.allPastorVotante = allPastorVotante;
    }

    public PastorVotanteFacadeLocal getPastorVotanteFacadeLocal() {
        return pastorVotanteFacadeLocal;
    }

    public void setPastorVotanteFacadeLocal(PastorVotanteFacadeLocal pastorVotanteFacadeLocal) {
        this.pastorVotanteFacadeLocal = pastorVotanteFacadeLocal;
    }

    public List<PadronVv> getLstPadronVv() {
        return lstPadronVv;
    }

    public void setLstPadronVv(List<PadronVv> lstPadronVv) {
        this.lstPadronVv = lstPadronVv;
    }

    @RolesAllowed("ADMIN")
    public void insert(PastorVotante pastorVotante) {
        try {
            //validate(pastorVotante);

            // allPastorVotante.add(pastorVotante);
            System.out.println("pastorvotanteeee" + pastorVotante);
            pastorVotanteFacadeLocal.create(pastorVotante);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PastorVotante> findByVotanteYpastor(Pastor pastor, PadronVv votante) {
        try {

            return pastorVotanteFacadeLocal.findByVotanteYpastor(pastor, votante);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void validate(Fiscal fiscal) {
        BusinessException be = new BusinessException();
        if (!fiscal.hasApeNom()) {
            be.addException(new BusinessException("Nombre cannot be empty"));
        }
        if (!fiscal.hasTel()) {
            be.addException(new BusinessException("Apellido cannot be empty"));
        }
        if (!fiscal.hasChatId()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }
        if (!fiscal.hasMesa()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }

        if (has(be.getExceptionList())) {
            throw be;
        }
    }

    @RolesAllowed("ADMIN")
    public void remove(PastorVotante pastorVotante) {
        this.pastorVotanteFacadeLocal.remove(pastorVotante);
        allPastorVotante.remove(pastorVotante);

    }

    @RolesAllowed("ADMIN")
    public void update(PastorVotante pastorVotante) {
        // validate(pastorVotante);
        allPastorVotante.remove(allPastorVotante.indexOf(pastorVotante));
        allPastorVotante.add(pastorVotante);
        pastorVotanteFacadeLocal.edit(pastorVotante);

    }

    public void desvincularVotantes(Pastor selectedPastor) {
        // Procedimiento para marcar como no vinculados los votantes que estaban relacionados con el pastor que se elimino
        this.setLstPadronVv(this.pastorVotanteFacadeLocal.findVotantesByPastor(selectedPastor));
        System.out.println("votantes relacioneados" +lstPadronVv);
        Iterator<PadronVv> it = lstPadronVv.iterator();

        while (it.hasNext()) {
            votante = it.next();
            votante.setVinculado(Boolean.FALSE);
            this.padronVvFacadeLocal.edit(votante);
        }
        //fin de procedimiento
        pastorVotanteFacadeLocal.removeByPastor(selectedPastor); //Elimino de la tabla pastorVotante los registros relacionados con el pastor que se elimina

        

    }

}
