/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.PadronVvFacadeLocal;
import DAO.PastorFacadeLocal;
import DAO.PastorVotanteFacadeLocal;
import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorVotante;
import com.github.adminfaces.starter.service.PastorService;
import com.github.adminfaces.starter.service.PastorVotanteService;
import com.github.adminfaces.starter.service.VotanteService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author USUARIO
 */
@Named
@SessionScoped
public class PastorFormMB implements Serializable {

    @Inject
    PastorService pastorService;
    @Inject
    PastorVotanteService pastorVotanteService;
    @Inject
    VotanteService votanteService;
    private Integer id;
    private Pastor pastor;
    private Pastor pastorSelect;
    private PastorVotante pastorVotante;
    List<PadronVv> lstVotantePastor;

    List<PadronVv> lstVotantes;

    private PadronVv votante;

    private DualListModel<PadronVv> votantes;
    @EJB
    private PastorFacadeLocal pastorFacadeLocal;

    @EJB
    private PastorVotanteFacadeLocal pastorVotanteFacadeLocal;

    @EJB
    private PadronVvFacadeLocal padronVvFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void init() {

        if (Faces.isAjaxRequest()) {
            return;
        }
        if (has(id)) {
            pastor = pastorFacadeLocal.find(id);

        } else {
            pastor = new Pastor();
        }
        pastorService.cargarPastores();
        pastorService.cargar_SI_pastores();
        

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    public PastorService getPastorService() {
        return pastorService;
    }

    public void setPastorService(PastorService pastorService) {
        this.pastorService = pastorService;
    }

    public Pastor getPastorSelect() {
        return pastorSelect;
    }

    public void setPastorSelect(Pastor pastorSelect) {
        this.pastorSelect = pastorSelect;
    }

    public PastorFacadeLocal getPastorFacadeLocal() {
        return pastorFacadeLocal;
    }

    public void setPastorFacadeLocal(PastorFacadeLocal pastorFacadeLocal) {
        this.pastorFacadeLocal = pastorFacadeLocal;
    }

    public List<PadronVv> getLstVotantePastor() {
        return lstVotantePastor;
    }

    public void setLstVotantePastor(List<PadronVv> lstVotantePastor) {
        this.lstVotantePastor = lstVotantePastor;
    }

    public DualListModel<PadronVv> getVotantes() {
        return votantes;
    }

    public void setVotantes(DualListModel<PadronVv> votantes) {
        this.votantes = votantes;
    }

    public PastorVotanteFacadeLocal getPastorVotanteFacadeLocal() {
        return pastorVotanteFacadeLocal;
    }

    public void setPastorVotanteFacadeLocal(PastorVotanteFacadeLocal pastorVotanteFacadeLocal) {
        this.pastorVotanteFacadeLocal = pastorVotanteFacadeLocal;
    }

    public List<PadronVv> getLstVotantes() {
        return lstVotantes;
    }

    public void setLstVotantes(List<PadronVv> lstVotante) {
        this.lstVotantes = lstVotante;
    }

    public PadronVv getVotante() {
        return votante;
    }

    public void setVotante(PadronVv votante) {
        this.votante = votante;
    }

    public PastorVotante getPastorVotante() {
        return pastorVotante;
    }

    public void setPastorVotante(PastorVotante pastorVotante) {
        this.pastorVotante = pastorVotante;
    }

    public void remove() throws IOException {
        if (has(pastor) && has(pastor.getId())) {
            pastorService.remove(pastor); //Seteo isActive en False
            pastorVotanteService.desvincularVotantes(pastor); //Elimino los votantes vinculados y en la tabla padron seteo vinculado en False
            addDetailMessage("Dirigente " + pastor.getApeNom()
                    + " ha sido borrado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("pages/pastor-list.xhtml");
        }
    }

    public void save() {

        String msg;
        if (pastor.getId() == null) {
            System.out.println("com.github.adminfaces.starter.bean.PastorFormMB.save()" + pastor);
            pastorService.insert(pastor);
            msg = "Dirigente " + pastor.getApeNom() + " created successfully";
        } else {
            pastorService.update(pastor);
            msg = "Dirigente " + pastor.getApeNom() + " updated successfully";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        pastor = new Pastor();
        id = null;
    }

    public boolean isNew() {
        return pastor == null || pastor.getId() == null;
    }

    public void handleChange() {
        System.out.println("New value: " + pastor);
    }

    public void recuperarVotantes() {
        // setear pastor seleccionado

        System.out.println("jajajajajaja" + pastorSelect);

        try {

            this.setLstVotantePastor(this.pastorVotanteFacadeLocal.findVotantesByPastor(pastorSelect));
        } catch (Exception ex) {
            Logger.getLogger(PastorFormMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cargarDualListModel();
    }

    public void cargarDualListModel() {

        this.setLstVotantes(padronVvFacadeLocal.findAll());

        Iterator<PadronVv> it = lstVotantePastor.iterator();

        while (it.hasNext()) {
            votante = it.next();
            if (lstVotantes.contains(votante)) {
                lstVotantes.remove(votante);
            }
        }

        List<PadronVv> votantesSource = lstVotantes;
        List<PadronVv> votantesTarget = new ArrayList<PadronVv>();
        votantes = new DualListModel<PadronVv>(votantesSource, votantesTarget);
        System.out.println("el duallist es " + votantes);
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((PadronVv) item).getApenom()).append("<br />");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Votantes tranferidos ");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void create() {

        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            this.pastorVotante.setPastor(pastor);

            //recorre el list de los alumnos afectados en el proyecto
            Iterator<PadronVv> it = votantes.getTarget().iterator();
            while (it.hasNext()) {

                votante = it.next();

                pastorVotante.setVotante(votante);

                //realiza el alta en la tabla relacional campaniaAgenda dependiendo de cuantos  se han seleccionado
                pastorVotanteFacadeLocal.create(pastorVotante);

            }

            sMensaje = "Votantes Asignados con éxito";

            severity = FacesMessage.SEVERITY_INFO;

            //limpiar campos
            //   this.limpiar();
        } catch (Exception ex) {
            System.out.println("------ entro al catch ----");
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }// fin crear

    public void handleKeyEvent() {
        text = text.toUpperCase();
    }
    
     public void vincularVotadorDirigente(){
         this.lstVotantePastor.add(votante);
     }
}
