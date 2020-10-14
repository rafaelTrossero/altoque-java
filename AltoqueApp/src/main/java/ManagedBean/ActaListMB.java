package ManagedBean;

import com.github.adminfaces.starter.infra.model.Filter;
import Modelo.Acta;

import Service.ActaService;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static recursos.Utils.addDetailMessage;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class ActaListMB implements Serializable {

    @Inject
    ActaService actaService;

    Integer id;

    Acta selectedActa;
    Acta acta;

    List<Acta> lstActas;
    LazyDataModel<Acta> actas;

    Filter<Acta> filter = new Filter<>(new Acta());

    List<Acta> selectedActas; //cars selected in checkbox column

    List<Acta> filteredValue;// datatable filteredValue attribute (column filters)

    //MULTISELECTVIEW
    private List<SelectItem> categories;
    private String selection;

    @PostConstruct
    public void initDataModel() {

        this.setLstActas(actaService.findAll());
       
        
        
    }

    public void clear() {
        filter = new Filter<Acta>(new Acta());
    }

    public void delete() {
        int numActas = 0;
        for (Acta selectedActa : selectedActas) {
            numActas++;
            actaService.remove(selectedActa);
        }
        selectedActas.clear();
        addDetailMessage(numActas + " acta deleted successfully!");
    }



    public ActaService getActaService() {
        return actaService;
    }

    public void setActaService(ActaService actaService) {
        this.actaService = actaService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Acta getSelectedActa() {
        return selectedActa;
    }

    public void setSelectedActa(Acta selectedActa) {
        this.selectedActa = selectedActa;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public List<Acta> getLstActas() {
        return lstActas;
    }

    public void setLstActas(List<Acta> lstActas) {
        this.lstActas = lstActas;
    }

    public LazyDataModel<Acta> getActas() {
        return actas;
    }

    public void setActas(LazyDataModel<Acta> actas) {
        this.actas = actas;
    }

    public Filter<Acta> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Acta> filter) {
        this.filter = filter;
    }

    public List<Acta> getSelectedActas() {
        return selectedActas;
    }

    public void setSelectedActas(List<Acta> selectedActas) {
        this.selectedActas = selectedActas;
    }

    public List<Acta> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Acta> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public List<SelectItem> getCategories() {
        return categories;
    }    
 
    public String getSelection() {
        return selection;
    }
    public void setSelection(String selection) {
        this.selection = selection;
    }
}
