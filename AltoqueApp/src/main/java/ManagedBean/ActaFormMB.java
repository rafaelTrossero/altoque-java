/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import Seguridad.LogonMB;
import Modelo.Acta;

import Service.ActaService;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static recursos.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;


/**
 * @author rmpestano
 */
@Named
@ViewScoped
public class ActaFormMB implements Serializable {

    private Long id;
    private Acta acta;
    

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

   

    public Integer getVotosGobernador() {
        return votosGobernador;
    }

    public void setVotosGobernador(Integer votosGobernador) {
        this.votosGobernador = votosGobernador;
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
            msg = "Acta de la mesa " + acta.getMesa() + " para el candidato a " + ", " + "  cargada con exito";
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

  
  
}
