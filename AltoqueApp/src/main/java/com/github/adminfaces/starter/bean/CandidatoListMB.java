/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.CandidatosFacadeLocal;
import DAO.FiscalActasFacadeLocal;

import com.github.adminfaces.starter.model.Candidatos;
import com.github.adminfaces.starter.model.CandidatosVotos;
import com.github.adminfaces.starter.model.FiscalActas;
import com.github.adminfaces.starter.util.Utils;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@Named
@ViewScoped
public class CandidatoListMB implements Serializable {

    Integer id;

    private List<SelectItem> lstSICandidatos;
    private List<Candidatos> lstCandidatos;
    private List<CandidatosVotos> lstCandidatosMunicipal;
     private List<CandidatosVotos> lstCandidatosProvincia;
    private Candidatos candidato;
    private List<SelectItem> lstSICargos;
    List<Candidatos> selectedCandidato;
    private String cargoSelect;

    String updateDialog;

    private CandidatosVotos candidatosVotos;
    private FiscalActas fiscalActa;

    List<CandidatosVotos> lstCandidatosVotos;

    //MULTISELECTVIEW
    private List<SelectItem> categories;
    private String selection;

    @Inject
    ActaFormMB actaFormMB;

    @EJB
    private CandidatosFacadeLocal candidatosFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    @EJB
    private FiscalActasFacadeLocal fiscalActasFacadeLocal;

    public CandidatoListMB() {

        this.candidato = candidato;
        candidatosVotos = new CandidatosVotos();
        fiscalActa = new FiscalActas();
    }

    public void init() {
        System.err.println("entro al INIT del list");
        if (Faces.isAjaxRequest()) {
            return;
        }

        cargar_SI_pastores();
        cargar_SI_cargos();
        // cargar_candidatosVotos();

    }

    @PostConstruct
    public void initDataModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SelectItem> getLstSICandidatos() {
        return lstSICandidatos;
    }

    public void setLstSICandidatos(List<SelectItem> lstSICandidatos) {
        this.lstSICandidatos = lstSICandidatos;
    }

    public List<Candidatos> getSelectedCandidato() {
        return selectedCandidato;
    }

    public void setSelectedCandidato(List<Candidatos> selectedCandidato) {
        this.selectedCandidato = selectedCandidato;
    }

    public CandidatosFacadeLocal getCandidatosFacadeLocal() {
        return candidatosFacadeLocal;
    }

    public void setCandidatosFacadeLocal(CandidatosFacadeLocal candidatosFacadeLocal) {
        this.candidatosFacadeLocal = candidatosFacadeLocal;
    }

    public List<SelectItem> getCategories() {
        return categories;
    }

    public void setCategories(List<SelectItem> categories) {
        this.categories = categories;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public List<SelectItem> getLstSICargos() {
        return lstSICargos;
    }

    public void setLstSICargos(List<SelectItem> lstSICargos) {
        this.lstSICargos = lstSICargos;
    }

    public String getCargoSelect() {
        return cargoSelect;
    }

    public void setCargoSelect(String cargoSelect) {
        this.cargoSelect = cargoSelect;
    }

    public List<Candidatos> getLstCandidatos() {
        return lstCandidatos;
    }

    public void setLstCandidatos(List<Candidatos> lstCandidatos) {
        this.lstCandidatos = lstCandidatos;
    }

    public Candidatos getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidatos candidato) {
        this.candidato = candidato;
    }

    public CandidatosVotos getCandidatosVotos() {
        return candidatosVotos;
    }

    public void setCandidatosVotos(CandidatosVotos candidatosVotos) {
        this.candidatosVotos = candidatosVotos;
    }

    public List<CandidatosVotos> getLstCandidatosVotos() {
        return lstCandidatosVotos;
    }

    public void setLstCandidatosVotos(List<CandidatosVotos> lstCandidatosVotos) {
        this.lstCandidatosVotos = lstCandidatosVotos;
    }

    public String getUpdateDialog() {
        return updateDialog;
    }

    public void setUpdateDialog(String updateDialog) {
        this.updateDialog = updateDialog;
    }

    public FiscalActas getFiscalActa() {
        return fiscalActa;
    }

    public void setFiscalActa(FiscalActas fiscalActa) {
        this.fiscalActa = fiscalActa;
    }

    public List<CandidatosVotos> getLstCandidatosMunicipal() {
        return lstCandidatosMunicipal;
    }

    public void setLstCandidatosMunicipal(List<CandidatosVotos> lstCandidatosMunicipal) {
        this.lstCandidatosMunicipal = lstCandidatosMunicipal;
    }

    public List<CandidatosVotos> getLstCandidatosProvincia() {
        return lstCandidatosProvincia;
    }

    public void setLstCandidatosProvincia(List<CandidatosVotos> lstCandidatosProvincia) {
        this.lstCandidatosProvincia = lstCandidatosProvincia;
    }

    public void cargar_SI_pastores() {
        this.setLstSICandidatos((new ArrayList<SelectItem>()));

        for (Candidatos d : this.candidatosFacadeLocal.findAll()) {
            SelectItem si = new SelectItem(d, d.getCandidato());
            this.getLstSICandidatos().add(si);

        }

    }//fin for

    public void cargar_candidatosVotos(FiscalActas acta) {
System.out.println("tipo: asdasdasdadadasdadasd");
        String dialogo = new String();
        String lugar = new String();

        int i = 0;
        System.out.println("tipo: " + acta.getTipo() + " mesa: " + acta.getMesa());
        /*
        if(acta.getMesa()>= 33 && acta.getMesa()<= 33 ){
            lugar="aconquija";
            acta.setTipo("aconquija");
        }*/

        this.setFiscalActa(this.fiscalActasFacadeLocal.findByIsCargadaTipo(acta.getTipo(), acta.getMesa()));
        System.out.println("fiscalActa es----  " + fiscalActa);
        if (fiscalActa == null) {
            if (acta.getTipo().equals("nacional")) {
                this.setLstCandidatosVotos((new ArrayList<CandidatosVotos>()));
                for (Candidatos d : this.candidatosFacadeLocal.findAllNacionales()) {

                    CandidatosVotos canVot = new CandidatosVotos();
                    canVot.setCandidato(d);

                    this.getLstCandidatosVotos().add(canVot);

                    i++;
                }
                // this.setUpdateDialog(":resultadosActa:actaResultados");
                dialogo = "PF('dlg2').show()";
            } else if (acta.getTipo().equals("provincial")) {
                this.setLstCandidatosVotos((new ArrayList<CandidatosVotos>()));
                for (Candidatos d : this.candidatosFacadeLocal.findAllProvinciales()) {

                    CandidatosVotos canVot = new CandidatosVotos();
                    canVot.setCandidato(d);

                    this.getLstCandidatosVotos().add(canVot);

                    i++;
                }
                // this.setUpdateDialog(":resultadosActaProv:actaResultadosProv");
                dialogo = "PF('dlg3').show()";
            } else if (acta.getTipo().equals("aconquija")) {
                 this.setLstCandidatosVotos((new ArrayList<CandidatosVotos>()));
               
                  this.setLstCandidatosMunicipal((new ArrayList<CandidatosVotos>()));
                  
                  cargarCandidatosProvinciales(); // carga de candidatos provinciales
                  
                for (Candidatos d : this.candidatosFacadeLocal.findAllByLugar(acta.getTipo())) {

                   
                    CandidatosVotos canVot = new CandidatosVotos();
                    canVot.setCandidato(d);
                    
                    this.getLstCandidatosMunicipal().add(canVot);
                    //this.getLstCandidatosVotos().add(canVot);

                    i++;
                }

                // UNO LOS LISTADOS
               lstCandidatosVotos.addAll(lstCandidatosProvincia);
                
                lstCandidatosVotos.addAll(lstCandidatosMunicipal);
                // this.setUpdateDialog(":resultadosActaProv:actaResultadosProv");
                dialogo = "PF('dlg3').show()";
            }
        } else {
            addDetailMessage("!!RESULTADOS YA CARGADOS para el ACTA ID: " + acta.getId(), FacesMessage.SEVERITY_FATAL);
            dialogo = "PF('dlgError').show()";
        }

        System.err.println("DIALOGO es" + dialogo);
        //  System.err.println("LISTA es" +lstCandidatosVotos.size());
        //RequestContext.getCurrentInstance().execute(dialogo);
        // PrimeFaces.current().dialog().openDynamic(dialogo);
        actaFormMB.setVotosGobernador(new Integer(0));
        actaFormMB.setVotosDipProv(new Integer(0));
        actaFormMB.setVotoSenador(new Integer(0));
        actaFormMB.setVotosIntendente(new Integer(0));
        actaFormMB.setVotosConcejal(new Integer(0));
        actaFormMB.setVotosPresidente(new Integer(0));
        actaFormMB.setVotosDipNac(new Integer(0));
        actaFormMB.setTotalNac(new Integer(0));
        actaFormMB.setTotalProv(new Integer(0));
        PrimeFaces.current().executeScript(dialogo);

    }//fin for

    public void cargar_SI_cargos() {
        this.setLstSICandidatos((new ArrayList<SelectItem>()));
        this.setLstSICargos((new ArrayList<SelectItem>()));

        for (String d : this.candidatosFacadeLocal.findCargos()) {
            SelectItem si = new SelectItem(d);
            this.getLstSICargos().add(si);

        }

    }//fin for

    public void recuperarCandidatos() {

        try {
            this.setLstCandidatos(this.candidatosFacadeLocal.findBycargo(cargoSelect));
        } catch (Exception ex) {
            Logger.getLogger(PastorFormMB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Candidato Seleccionado", ((Candidatos) event.getObject()).getCandidato());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // setDtVotantesVinculados(Boolean.FALSE); 

    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Candidato Deseleccionado", ((Candidatos) event.getObject()).getCandidato());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // setDtVotantesVinculados(Boolean.TRUE);
    }
    
    public void cargarCandidatosProvinciales(){
         this.setLstCandidatosProvincia((new ArrayList<CandidatosVotos>()));
                 
                for (Candidatos d : this.candidatosFacadeLocal.findAllProvincialesByLugar("provincia")) {

                    CandidatosVotos canVot = new CandidatosVotos();
                    canVot.setCandidato(d);

                    this.getLstCandidatosProvincia().add(canVot);

                   
                }
                System.out.println("LOS PROVINCIALES SON::::" +lstCandidatosProvincia);
    }

}
