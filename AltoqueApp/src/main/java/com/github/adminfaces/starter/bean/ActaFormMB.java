/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.starter.model.Acta;
import com.github.adminfaces.starter.model.CandidatosVotos;
import com.github.adminfaces.starter.model.FiscalActas;
import com.github.adminfaces.starter.service.ActaService;
import com.github.adminfaces.starter.service.FiscalActaService;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

import org.primefaces.event.RowEditEvent;

/**
 * @author rmpestano
 */
@Named
@ViewScoped
public class ActaFormMB implements Serializable {

    private Long id;
    private Acta acta;
    private FiscalActas actaSelec;

    private Integer votosGobernador;
    private Integer votosDipProv;
    private Integer votoSenador;
    private Integer votosIntendente;
    private Integer votosConcejal;
    private Integer votosPresidente;
    private Integer votosDipNac;
    private Integer totalNac;
    private Integer totalProv;

    @Inject
    ActaService actaService;
    @Inject
    FiscalActaService fiscalActaService;
    @Inject
    CandidatoListMB candidatoListMB;
    @Inject
    LogonMB logonMB;

    public void init() {
        if (Faces.isAjaxRequest()) {
            return;
        }
        if (has(id)) {
            acta = actaService.findById(id);

        } else {
            acta = new Acta();

        }
        actaSelec = new FiscalActas();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public ActaService getActaService() {
        return actaService;
    }

    public void setActaService(ActaService actaService) {
        this.actaService = actaService;
    }

    public FiscalActas getActaSelec() {
        return actaSelec;
    }

    public void setActaSelec(FiscalActas actaSelec) {
        this.actaSelec = actaSelec;
    }

    public Integer getVotosGobernador() {
        return votosGobernador;
    }

    public void setVotosGobernador(Integer votosGobernador) {
        this.votosGobernador = votosGobernador;
    }

    public FiscalActaService getFiscalActaService() {
        return fiscalActaService;
    }

    public void setFiscalActaService(FiscalActaService fiscalActaService) {
        this.fiscalActaService = fiscalActaService;
    }

    public CandidatoListMB getCandidatoListMB() {
        return candidatoListMB;
    }

    public void setCandidatoListMB(CandidatoListMB candidatoListMB) {
        this.candidatoListMB = candidatoListMB;
    }

    public LogonMB getLogonMB() {
        return logonMB;
    }

    public void setLogonMB(LogonMB logonMB) {
        this.logonMB = logonMB;
    }

    public Integer getVotosDipProv() {
        return votosDipProv;
    }

    public void setVotosDipProv(Integer votosDipProv) {
        this.votosDipProv = votosDipProv;
    }

    public Integer getVotoSenador() {
        return votoSenador;
    }

    public void setVotoSenador(Integer votoSenador) {
        this.votoSenador = votoSenador;
    }

    public Integer getVotosIntendente() {
        return votosIntendente;
    }

    public void setVotosIntendente(Integer votosIntendente) {
        this.votosIntendente = votosIntendente;
    }

    public Integer getVotosConcejal() {
        return votosConcejal;
    }

    public void setVotosConcejal(Integer votosConcejal) {
        this.votosConcejal = votosConcejal;
    }

    public Integer getVotosPresidente() {
        return votosPresidente;
    }

    public void setVotosPresidente(Integer votosPresidente) {
        this.votosPresidente = votosPresidente;
    }

    public Integer getVotosDipNac() {
        return votosDipNac;
    }

    public void setVotosDipNac(Integer votosDipNac) {
        this.votosDipNac = votosDipNac;
    }

    public Integer getTotalNac() {
        return totalNac;
    }

    public void setTotalNac(Integer totalNac) {
        this.totalNac = totalNac;
    }

    public Integer getTotalProv() {
        return totalProv;
    }

    public void setTotalProv(Integer totalProv) {
        this.totalProv = totalProv;
    }

    public void remove() throws IOException {
        if (has(acta) && has(acta.getId())) {
            actaService.remove(acta);
            addDetailMessage("Acta  borrada");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("acta-list.jsf");
        }
    }

    public void save() {
        String msg;
        System.out.println("id de acta es------------------->" + acta.getId());
        if (acta.getId() == null) {
            actaService.insert(acta);
            msg = "Acta de la mesa " + acta.getMesa() + " para el candidato a " + acta.getCandidato().getCargo() + ", " + acta.getCandidato().getCandidato() + "  cargada con exito";
        } else {
            actaService.update(acta);
            msg = "Acta  actualizada con exito";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        acta = new Acta();
        id = null;
    }

    public boolean isNew() {
        return acta == null || acta.getId() == null;
    }

    public void onCellEdit(CandidatosVotos can) {

        
        switch (can.getCandidato().getCargo()) {
            case "gobernador":
               
                this.setVotosGobernador(votosGobernador + can.getCantidadVotos());
                break;
            case "diputado_provincial":
                this.setVotosDipProv(votosDipProv + can.getCantidadVotos());
                break;
            case "senador":
                 this.setVotoSenador(votoSenador + can.getCantidadVotos());
                break;
            case "intendente":
                 this.setVotosIntendente(votosIntendente + can.getCantidadVotos());
                break;
            case "concejales":
                 this.setVotosConcejal(votosConcejal + can.getCantidadVotos());
                break;
                case "presidente":
                   
                 this.setVotosPresidente(votosPresidente + can.getCantidadVotos());
                break;
                case "diputado_nacional":
                 this.setVotosDipNac(votosDipNac + can.getCantidadVotos());
                break;

        }

       /* this.setTotalNac(votosPresidente + votosDipNac);
          this.setTotalProv(votosGobernador + votosDipProv +votoSenador + votosIntendente + votosConcejal);*/

    }

    public void onRowEdit(RowEditEvent event) {
        System.out.println("dale que vaaaa" + event.getObject());
        FacesMessage msg = new FacesMessage("Votos cargados", ((CandidatosVotos) event.getObject()).getCandidato().getCandidato());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("cancelado", ((CandidatosVotos) event.getObject()).getCandidato().getCandidato());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardarActa() {
        CandidatosVotos candiVot = new CandidatosVotos();
        acta = new Acta();
        String tipoActa = actaSelec.getTipo();

        Iterator<CandidatosVotos> it = candidatoListMB.getLstCandidatosVotos().iterator();
        while (it.hasNext()) {
            candiVot = it.next();
            acta.setCandidato(candiVot.getCandidato());
            acta.setCantidad(candiVot.getCantidadVotos());
            acta.setMesa(actaSelec.getMesa());
            acta.setFiscal(actaSelec.getFiscal());
            acta.setFecha(Calendar.getInstance().getTime());
            acta.setActa_fiscal(actaSelec);

            save();
            acta = new Acta();

        }
        actaSelec.setIsCargada(Boolean.TRUE);
        fiscalActaService.update(actaSelec);
        this.candidatoListMB.setLstCandidatosVotos((new ArrayList<CandidatosVotos>()));

        if (tipoActa.equals("provincial")) {
            // RequestContext.getCurrentInstance().execute("PF('dlg3').close()");
            PrimeFaces.current().executeScript("PF('dlg3').close()");
        } else {
            // RequestContext.getCurrentInstance().execute("PF('dlg2').close()"); 
            PrimeFaces.current().executeScript("PF('dlg2').close()");
        }

    }
}
