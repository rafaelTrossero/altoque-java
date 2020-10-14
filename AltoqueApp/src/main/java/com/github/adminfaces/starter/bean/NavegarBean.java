/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.service.PastorService;
import com.github.adminfaces.starter.service.VotanteService;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jmoreno
 */
@ManagedBean
@RequestScoped
public class NavegarBean {

    @Inject
    PastorService pastorService;
    @Inject
    VotanteService votanteService;

    public PastorService getPastorService() {
        return pastorService;
    }

    public void setPastorService(PastorService pastorService) {
        this.pastorService = pastorService;
    }

    public VotanteService getVotanteService() {
        return votanteService;
    }

    public void setVotanteService(VotanteService votanteService) {
        this.votanteService = votanteService;
    }

    
    public NavegarBean() {
    }

    public String entrarFormAsignacionVotantes() {

        this.getPastorService().cargar_SI_pastores();
       

        return "/protected/dirigente-votante-form";
    }
}
