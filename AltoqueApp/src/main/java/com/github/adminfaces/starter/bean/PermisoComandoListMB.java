/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.PastorFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.PermisosComando;


import com.github.adminfaces.starter.service.PermisoComandoService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import com.github.adminfaces.template.exception.BusinessException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author USUARIO
 */
@Named
@ViewScoped
public class PermisoComandoListMB implements Serializable {

    @Inject
    PermisoComandoService permisoComandoService;
    

    Integer id;

    LazyDataModel<PermisosComando> permisosComandos;
    private List<SelectItem> lstSIPermisoComando;

    Filter<PermisosComando> filter = new Filter<>(new PermisosComando());

    List<PermisosComando> selectedPermisosComando; //cars selected in checkbox column

    List<PermisosComando> filteredValue;// datatable filteredValue attribute (column filters)

    @EJB
    private PastorFacadeLocal pastorFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public void init() {
        System.err.println("entro al INIT del list");
        if (Faces.isAjaxRequest()) {
            return;
        }
    
       // cargar_SI_pastores();
      

    }

    @PostConstruct
    public void initDataModel() {

        permisosComandos = new LazyDataModel<PermisosComando>() {
            @Override
            public List<PermisosComando> load(int first, int pageSize,
                    String sortField, SortOrder sortOrder,
                    Map<String, Object> filters) {
                com.github.adminfaces.starter.infra.model.SortOrder order = null;
                if (sortOrder != null) {
                    order = sortOrder.equals(SortOrder.ASCENDING) ? com.github.adminfaces.starter.infra.model.SortOrder.ASCENDING
                            : sortOrder.equals(SortOrder.DESCENDING) ? com.github.adminfaces.starter.infra.model.SortOrder.DESCENDING
                            : com.github.adminfaces.starter.infra.model.SortOrder.UNSORTED;
                }
                filter.setFirst(first).setPageSize(pageSize)
                        .setSortField(sortField).setSortOrder(order)
                        .setParams(filters);

                List<PermisosComando> list = permisoComandoService.paginate(filter);
                setRowCount((int) permisoComandoService.count(filter));
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public PermisosComando getRowData(String key) {
                return permisoComandoService.findById(new Integer(key));
            }
        };
    }

    public void clear() {
        filter = new Filter<PermisosComando>(new PermisosComando());
    }

    public void findPastorById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide permisoComando ID to load");
        }
        selectedPermisosComando.add(permisoComandoService.findById(id));
    }

    // borrado logico, cambio isActive a FALSE
    public void delete() {
        int i = 0;
        for (PermisosComando selectedPerm : selectedPermisosComando) {
            i++;
            selectedPerm.setIsActive(false);
            permisoComandoService.update(selectedPerm);
            
        }
        selectedPermisosComando.clear();
        addDetailMessage(i + " PermisosComando borrado!..");
    }

    public PermisoComandoService getPermisoComandoService() {
        return permisoComandoService;
    }

    public void setPermisoComandoService(PermisoComandoService permisoComandoService) {
        this.permisoComandoService = permisoComandoService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<PermisosComando> getPermisosComandos() {
        return permisosComandos;
    }

    public void setPermisosComandos(LazyDataModel<PermisosComando> permisosComandos) {
        this.permisosComandos = permisosComandos;
    }

    public List<SelectItem> getLstSIPermisoComando() {
        return lstSIPermisoComando;
    }

    public void setLstSIPermisoComando(List<SelectItem> lstSIPermisoComando) {
        this.lstSIPermisoComando = lstSIPermisoComando;
    }

    public Filter<PermisosComando> getFilter() {
        return filter;
    }

    public void setFilter(Filter<PermisosComando> filter) {
        this.filter = filter;
    }

    public List<PermisosComando> getSelectedPermisosComando() {
        return selectedPermisosComando;
    }

    public void setSelectedPermisosComando(List<PermisosComando> selectedPermisosComando) {
        this.selectedPermisosComando = selectedPermisosComando;
    }

    public List<PermisosComando> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<PermisosComando> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public PastorFacadeLocal getPastorFacadeLocal() {
        return pastorFacadeLocal;
    }

    public void setPastorFacadeLocal(PastorFacadeLocal pastorFacadeLocal) {
        this.pastorFacadeLocal = pastorFacadeLocal;
    }

   
}

