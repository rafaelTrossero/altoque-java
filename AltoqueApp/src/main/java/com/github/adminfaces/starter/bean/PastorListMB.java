/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.PastorFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.service.PastorService;
import com.github.adminfaces.starter.service.PastorVotanteService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author USUARIO
 */
@Named
@ViewScoped
public class PastorListMB implements Serializable {

    @Inject
    PastorService pastorService;
    @Inject
    PastorVotanteService pastorVotanteService;

    Integer id;

    LazyDataModel<Pastor> pastors;
    private List<SelectItem> lstSIPastores;

    Filter<Pastor> filter = new Filter<>(new Pastor());

    List<Pastor> selectedPastors; //cars selected in checkbox column

    List<Pastor> filteredValue;// datatable filteredValue attribute (column filters)
    List<Pastor> lstPastores;

    @EJB
    private PastorFacadeLocal pastorFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public void init() {
        System.err.println("entro al INIT del list");
        if (Faces.isAjaxRequest()) {
            return;
        }
    
        cargar_SI_pastores();
        
       
      

    }

    @PostConstruct
    public void initDataModel() {

      pastorService.cargarPastores();
        this.setLstPastores(pastorService.getAllPastores());
    }

    public void clear() {
        filter = new Filter<Pastor>(new Pastor());
    }

    public void findPastorById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Car ID to load");
        }
        selectedPastors.add(pastorService.findById(id));
    }

    // borrado logico, cambio isActive a FALSE
    public void delete() {
        int i = 0;
        for (Pastor selectedPastor : selectedPastors) {
            i++;
            selectedPastor.setIsActive(false);
            pastorService.update(selectedPastor);
            pastorVotanteService.desvincularVotantes(selectedPastor);
        }
        selectedPastors.clear();
        addDetailMessage(i + " Dirigente borrado!.. Se desvincularán los votantes asignados");
    }

    public PastorService getPastorService() {
        return pastorService;
    }

    public void setPastorService(PastorService pastorService) {
        this.pastorService = pastorService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<Pastor> getPastors() {
        return pastors;
    }

    public void setPastors(LazyDataModel<Pastor> pastors) {
        this.pastors = pastors;
    }

    public Filter<Pastor> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Pastor> filter) {
        this.filter = filter;
    }

    public List<Pastor> getSelectedPastors() {
        return selectedPastors;
    }

    public void setSelectedPastors(List<Pastor> selectedPastors) {
        this.selectedPastors = selectedPastors;
    }

    public List<Pastor> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Pastor> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public List<SelectItem> getLstSIPastores() {
        return lstSIPastores;
    }

    public void setLstSIPastores(List<SelectItem> lstSIPastores) {
        this.lstSIPastores = lstSIPastores;
    }

    public List<Pastor> getLstPastores() {
        return lstPastores;
    }

    public void setLstPastores(List<Pastor> lstPastores) {
        this.lstPastores = lstPastores;
    }

    public void cargar_SI_pastores() {
        this.setLstSIPastores(new ArrayList<SelectItem>());
        System.out.println("___:.............::::::____" + pastorService.getAllPastores());
        for (Pastor d : this.pastorService.getAllPastores()) {
            SelectItem si = new SelectItem(d, d.getApeNom());
            this.getLstSIPastores().add(si);

        }

    }//fin for

   
}
