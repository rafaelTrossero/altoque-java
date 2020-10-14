/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.CarFacadeLocal;
import DAO.PadronVvFacadeLocal;
import DAO.PastorFacadeLocal;
import DAO.PastorVotanteFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorVotante;
import com.github.adminfaces.starter.service.PastorService;
import com.github.adminfaces.starter.service.PastorVotanteService;
import com.github.adminfaces.starter.service.VotanteService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import com.github.adminfaces.template.exception.BusinessException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author rat_5
 */
@Named
@ViewScoped
public class VotanteListMB implements Serializable {

    @Inject
    VotanteService votanteService;

    @Inject
    PastorService pastorService;

    @Inject
    PastorVotanteService pastorVotanteService;

    @EJB
    private PastorFacadeLocal pastorFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    private String criterioBusqueda;

    String linkWhatsapp;

    Integer id;

    Integer dni;

    String criterioSeleccionado;
    Boolean dtVotantesVinculados;
    Boolean panelBusqueda;
    Boolean btVincular;

    LazyDataModel<PadronVv> votantes;

    List<PadronVv> lstVotantes;
    List<PadronVv> lstVotantePastor;
     List<PadronVv> lstVotantesAuto;

    PadronVv votador;

    Pastor pastorSelect;
    Car autoSelect;

    PastorVotante pastorVotante;

    Filter<PadronVv> filter = new Filter<>(new PadronVv());

    List<PadronVv> selectedVotantes; //cars selected in checkbox column

    List<PadronVv> filteredValue;// datatable filteredValue attribute (column filters)

    private List<SelectItem> lstSIPastores;
    private List<SelectItem> lstSIAutos;

    @EJB
    private PastorVotanteFacadeLocal pastorVotanteFacadeLocal;

    @EJB
    private CarFacadeLocal carFacadeLocal;

    @EJB
    private PadronVvFacadeLocal padronVvFacadeLocal;

    @PostConstruct
    public void init() {
        if (Faces.isAjaxRequest()) {
            return;
        }
        this.cargar_SI_pastores();
        this.cargar_SI_autos();
        pastorSelect = new Pastor();
        lstVotantes = new ArrayList<>();
        lstVotantePastor = new ArrayList<>();
        votador = new PadronVv();
        criterioSeleccionado = "dni";
        dtVotantesVinculados = Boolean.TRUE;
        autoSelect = new Car();
        panelBusqueda =  Boolean.FALSE;
        btVincular = Boolean.TRUE;

    }

    public VotanteService getVotanteService() {
        return votanteService;
    }

    public void setVotanteService(VotanteService votanteService) {
        this.votanteService = votanteService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<PadronVv> getVotantes() {
        return votantes;
    }

    public void setVotantes(LazyDataModel<PadronVv> votantes) {
        this.votantes = votantes;
    }

    public Filter<PadronVv> getFilter() {
        return filter;
    }

    public void setFilter(Filter<PadronVv> filter) {
        this.filter = filter;
    }

    public List<PadronVv> getSelectedVotantes() {
        return selectedVotantes;
    }

    public void setSelectedVotantes(List<PadronVv> selectedVotantes) {
        this.selectedVotantes = selectedVotantes;
    }

    public List<PadronVv> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<PadronVv> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public List<PadronVv> getLstVotantes() {
        return lstVotantes;
    }

    public void setLstVotantes(List<PadronVv> lstVotantes) {
        this.lstVotantes = lstVotantes;
    }

    public List<PadronVv> getLstVotantesDni() {
        return votanteService.getDniPadronVv();
    }

    public PastorFacadeLocal getPastorFacadeLocal() {
        return pastorFacadeLocal;
    }

    public void setPastorFacadeLocal(PastorFacadeLocal pastorFacadeLocal) {
        this.pastorFacadeLocal = pastorFacadeLocal;
    }

    public PadronVv getVotador() {
        return votador;
    }

    public void setVotador(PadronVv votador) {
        this.votador = votador;
    }

    public List<SelectItem> getLstSIPastores() {
        return lstSIPastores;
    }

    public void setLstSIPastores(List<SelectItem> lstSIPastores) {
        this.lstSIPastores = lstSIPastores;
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

    public PastorVotanteFacadeLocal getPastorVotanteFacadeLocal() {
        return pastorVotanteFacadeLocal;
    }

    public void setPastorVotanteFacadeLocal(PastorVotanteFacadeLocal pastorVotanteFacadeLocal) {
        this.pastorVotanteFacadeLocal = pastorVotanteFacadeLocal;
    }

    public List<PadronVv> getLstVotantePastor() {
        return lstVotantePastor;
    }

    public void setLstVotantePastor(List<PadronVv> lstVotantePastor) {
        this.lstVotantePastor = lstVotantePastor;
    }

    public PastorVotanteService getPastorVotanteService() {
        return pastorVotanteService;
    }

    public void setPastorVotanteService(PastorVotanteService pastorVotanteService) {
        this.pastorVotanteService = pastorVotanteService;
    }

    public PastorVotante getPastorVotante() {
        return pastorVotante;
    }

    public void setPastorVotante(PastorVotante pastorVotante) {
        this.pastorVotante = pastorVotante;
    }

    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(String criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public Boolean getDtVotantesVinculados() {
        return dtVotantesVinculados;
    }

    public void setDtVotantesVinculados(Boolean dtVotantesVinculados) {
        this.dtVotantesVinculados = dtVotantesVinculados;
    }

    public String getLinkWhatsapp() {
        return linkWhatsapp;
    }

    public void setLinkWhatsapp(String linkWhatsapp) {
        this.linkWhatsapp = linkWhatsapp;
    }

    public Car getAutoSelect() {
        return autoSelect;
    }

    public void setAutoSelect(Car autoSelect) {
        this.autoSelect = autoSelect;
    }

    public List<SelectItem> getLstSIAutos() {
        return lstSIAutos;
    }

    public void setLstSIAutos(List<SelectItem> lstSIAutos) {
        this.lstSIAutos = lstSIAutos;
    }

    public List<PadronVv> getLstVotantesAuto() {
        return lstVotantesAuto;
    }

    public void setLstVotantesAuto(List<PadronVv> lstVotantesAuto) {
        this.lstVotantesAuto = lstVotantesAuto;
    }

    public Boolean getPanelBusqueda() {
        return panelBusqueda;
    }

    public void setPanelBusqueda(Boolean panelBusqueda) {
        this.panelBusqueda = panelBusqueda;
    }

    public Boolean getBtVincular() {
        return btVincular;
    }

    public void setBtVincular(Boolean btVincular) {
        this.btVincular = btVincular;
    }

    public void cargar_SI_pastores() {

        this.setLstSIPastores(new ArrayList<SelectItem>());

        for (Pastor d : this.pastorFacadeLocal.findByIsActive(Boolean.TRUE)) {
            SelectItem si = new SelectItem(d, d.getApeNom());
            this.getLstSIPastores().add(si);

        }

    }//fin for

    public void cargar_SI_autos() {

        this.setLstSIAutos(new ArrayList<SelectItem>());

        for (Car d : this.carFacadeLocal.findAll()) {
            SelectItem si = new SelectItem(d, d.getName() + " " + d.getModel() + " " + d.getPatente());
            this.getLstSIAutos().add(si);

        }

    }//fin for

    public void recuperarVotantes() {
        // setear pastor seleccionado
         this.setPanelBusqueda(Boolean.TRUE);
        try {

            this.setLinkWhatsapp("https://wa.me/" + pastorSelect.getTelefono());
            this.setLstVotantePastor(this.pastorVotanteFacadeLocal.findVotantesByPastor(pastorSelect));
            this.setLstVotantePastor(lstVotantePastor.stream().distinct().collect(Collectors.toList()));
            dtVotantesVinculados = Boolean.TRUE;
            if (lstVotantePastor.isEmpty()) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "!", "No hay votantes vinculados al Dirigente."));
            }
        } catch (Exception ex) {
            Logger.getLogger(PastorFormMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cargarDualListModel();
    }
    
     public void recuperarVotantesAuto() {
        // setear pastor seleccionado
        this.setPanelBusqueda(Boolean.TRUE);
        try {

            this.setLinkWhatsapp("https://wa.me/" + pastorSelect.getTelefono());
            this.setLstVotantesAuto(this.padronVvFacadeLocal.findByAuto(autoSelect));
            this.setLstVotantePastor(this.pastorVotanteFacadeLocal.findVotantesByPastor(pastorSelect));
            this.setLstVotantesAuto(lstVotantesAuto.stream().distinct().collect(Collectors.toList()));
            
            dtVotantesVinculados = Boolean.TRUE;
            if (lstVotantesAuto.isEmpty()) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "!", "No hay votantes vinculados al Auto."));
            }
        } catch (Exception ex) {
            Logger.getLogger(PastorFormMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cargarDualListModel();
    }

    public void vincularVotadorDirigente() {

        votador.setCar(autoSelect);

        System.out.println("El auto del votante es -----" + votador.getCar());
        if (lstVotantePastor.contains(votador)) {
            throw new BusinessException("La persona que intenta agregar ya se encuentra vinculada al dirigente.");
        } else {
            lstVotantePastor.add(votador);
             addDetailMessage("Se agregó " +votador.getApenom()+ ". Recuerde que puede ingresar el telefono del votante en la celda telefono");
        }
        this.setBtVincular(Boolean.FALSE);
    }
    
    public void vincularVotadorAuto() {

        //votador.setCar(autoSelect);

        
        if (lstVotantesAuto.contains(votador)) {
            throw new BusinessException("La persona que intenta agregar ya se encuentra vinculada al dirigente.");
        } else {
            lstVotantesAuto.add(votador);
           addDetailMessage("Se agregó " +votador.getApenom()+ ". Recuerde que puede ingresar el telefono del votante en la celda telefono");
       
        }
        this.setBtVincular(Boolean.FALSE);
    }
    
        public void confirmarVinculacionVotadorAuto() {
        pastorVotante = new PastorVotante();
        //recorre el list de los alumnos afectados en el proyecto

        Iterator<PadronVv> it = lstVotantesAuto.iterator();
        while (it.hasNext()) {
            votador = it.next();
           
            votador.setCar(autoSelect);
            System.out.println("------------" +votador.getTelefono());
            padronVvFacadeLocal.edit(votador);
            
        }

        if (lstVotantesAuto.size() > 1) {
            addDetailMessage(lstVotantesAuto.size() + " personas vinculadas al Auto!");
        } else {
            addDetailMessage("La persona ha sido vinculada!");
        }
    }

    public void confirmarVinculacionVotadorDirigente() {
        pastorVotante = new PastorVotante();
        //recorre el list de los alumnos afectados en el proyecto

        Iterator<PadronVv> it = lstVotantePastor.iterator();
        while (it.hasNext()) {
            votador = it.next();
            System.out.println("El auto del votante es --confirmarVinculacionVotadorDirigente---" + votador.getCar());
            
            votador.setVinculado(Boolean.TRUE);

            System.out.println("EL TELEFONO ES :::::::::-----" + votador.getTelefono());
            pastorVotante.setPastor(pastorSelect);
            pastorVotante.setVotante(votador);
            pastorVotante.setIsActive(true);
            padronVvFacadeLocal.edit(votador);
            if (pastorVotanteService.findByVotanteYpastor(pastorSelect, votador).isEmpty()) {

                pastorVotanteService.insert(pastorVotante);
            }

        }

        if (lstVotantePastor.size() > 1) {
            addDetailMessage(lstVotantePastor.size() + " personas vinculadas al dirigente!");
        } else {
            addDetailMessage("La persona ha sido vinculada!");
        }
    }

    public void clear() {
        filter = new Filter<PadronVv>(new PadronVv());
    }

    public void findCarById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide votante ID to load");
        }
        selectedVotantes.add(votanteService.findById(id));
    }

    public void findCarByDNI(Integer dni) {
        System.out.println("DNI es:::" + dni);
        if (dni == null) {
            throw new BusinessException("Provide votante ID to load");
        }
        selectedVotantes.add(votanteService.findByDNI(dni));

    }

    public void findCarByDNI2() {
        votador = new PadronVv();
        System.out.println("DNI es:::" + dni);
        if (dni == null) {
            throw new BusinessException("Provide votante ID to load");
        }
        this.setVotador(votanteService.findByDNI(dni));

    }

    public void buscarVotantePorCriterio() {
        votador = new PadronVv();

        switch (criterioSeleccionado) {
            case "dni":
                this.setLstVotantes(votanteService.findByDNIList(Integer.parseInt(criterioBusqueda)));
                // this.setVotador(votanteService.findByDNI(dni));
                break;
            case "apenom":
                this.setLstVotantes(votanteService.findByApenom(criterioBusqueda));
                break;
            case "orden":

                this.setLstVotantes(votanteService.findByOrden(criterioBusqueda));

                break;

        }
        if (criterioSeleccionado == null) {
            throw new BusinessException("Debe seleccionar un criterio de busqueda");
        }
        if (criterioBusqueda == null) {
            throw new BusinessException("Debe ingresar dato para buscar");
        }

    }

    public void delete() {
        int numVotantes = 0;
        for (PadronVv selectedVot : selectedVotantes) {
            numVotantes++;
            votanteService.remove(selectedVot);
        }
        selectedVotantes.clear();
        addDetailMessage(numVotantes + " votantes deleted successfully!");
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((PadronVv) event.getObject()).getApenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setDtVotantesVinculados(Boolean.FALSE);
        System.out.println("mostraaaa" + dtVotantesVinculados);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Persona deseleccionada", ((PadronVv) event.getObject()).getApenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setDtVotantesVinculados(Boolean.TRUE);
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Persona editada", ((PadronVv) event.getObject()).getApenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cancelado para", ((PadronVv) event.getObject()).getApenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
