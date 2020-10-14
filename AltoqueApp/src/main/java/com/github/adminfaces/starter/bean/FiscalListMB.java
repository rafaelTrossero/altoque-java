/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Fiscal;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.service.FiscalService;
import com.github.adminfaces.starter.service.PastorService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import com.github.adminfaces.template.exception.BusinessException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author USUARIO
 */
@Named
@ViewScoped
public class FiscalListMB implements Serializable {
      
    @Inject
    FiscalService fiscalService;

    Integer id;

    LazyDataModel<Fiscal> fiscals;

    Filter<Fiscal> filter = new Filter<>(new Fiscal());

    List<Fiscal> selectedFiscals; //cars selected in checkbox column

    List<Fiscal> filteredValue;// datatable filteredValue attribute (column filters)
    
     List<Fiscal> lstFiscales;

    @PostConstruct
    public void initDataModel() {
        fiscalService.cargarFiscales();
        this.setLstFiscales(fiscalService.getAllFiscales());
         
    }

    public void clear() {
        filter = new Filter<Fiscal>(new Fiscal());
    }

 

    public void findFiscalById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Fiscal ID to load");
        }
        selectedFiscals.add(fiscalService.findById(id));
    }

    public void delete() {
        int i = 0;
        for (Fiscal selectedFiscal : selectedFiscals) {
            i++;
            fiscalService.remove(selectedFiscal);
        }
        selectedFiscals.clear();
        addDetailMessage(i + " Fiscal borrado!");
    }

    public FiscalService getFiscalService() {
        return fiscalService;
    }

    public void setFiscalService(FiscalService fiscalService) {
        this.fiscalService = fiscalService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<Fiscal> getFiscals() {
        return fiscals;
    }

    public void setFiscals(LazyDataModel<Fiscal> fiscals) {
        this.fiscals = fiscals;
    }

    public Filter<Fiscal> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Fiscal> filter) {
        this.filter = filter;
    }

    public List<Fiscal> getSelectedFiscals() {
        return selectedFiscals;
    }

    public void setSelectedFiscals(List<Fiscal> selectedFiscals) {
        this.selectedFiscals = selectedFiscals;
    }

    public List<Fiscal> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Fiscal> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public List<Fiscal> getLstFiscales() {
        return lstFiscales;
    }

    public void setLstFiscales(List<Fiscal> lstFiscales) {
        this.lstFiscales = lstFiscales;
    }
    
}
