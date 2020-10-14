package com.github.adminfaces.starter.bean;

import DAO.PastorCarFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorCar;
import com.github.adminfaces.starter.service.CarService;
import com.github.adminfaces.starter.service.PastorCarService;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class CarListMB implements Serializable {

    @Inject
    CarService carService;

    @Inject
    PastorCarService pastorCarService;

    @EJB
    private PastorCarFacadeLocal pastorCarFacadeLocal;

    Integer id;

    String criterioSeleccionado;
    String criterioBusqueda;
    Car selectedCar;
    Car car;
    PastorCar pastorCar;
    Pastor pastorSelect;
    List<Car> lstPastorCar;
    List<PadronVv> lstVotantesAuto;
    List<Car> lstCars;
    LazyDataModel<Car> cars;
    Boolean dtAutosVinculados;
     Boolean panelBusqueda;
     Boolean btVincular;

    Filter<Car> filter = new Filter<>(new Car());

    List<Car> selectedCars; //cars selected in checkbox column

    List<Car> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        dtAutosVinculados = Boolean.TRUE;
        panelBusqueda =  Boolean.FALSE;
         btVincular = Boolean.TRUE;
        criterioSeleccionado = "todos";
         carService.cargarCar();
         this.setLstCars(carService.findAll());
    }

    public void clear() {
        filter = new Filter<Car>(new Car());
    }

    public List<String> completeModel(String query) {
        List<String> result = carService.getModels(query);
        return result;
    }

    public void findCarById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Car ID to load");
        }
        selectedCars.add(carService.findById(id));
    }

    public void delete() {
        int numCars = 0;
        for (Car selectedCar : selectedCars) {
            numCars++;
            carService.remove(selectedCar);
        }
        selectedCars.clear();
        addDetailMessage(numCars + " cars deleted successfully!");
    }

    public void recuperarAutos() {
        // setear pastor seleccionado
        this.setPanelBusqueda(Boolean.TRUE);

        try {
            this.setLstPastorCar(this.pastorCarFacadeLocal.findCarByPastor(pastorSelect));
            if (lstPastorCar.isEmpty()) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "!", "No hay vehiculos vinculados al Dirigente."));
            }
        } catch (Exception ex) {
            Logger.getLogger(PastorFormMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cargarDualListModel();
    }

    public void buscarAutoPorCriterio() {

        switch (criterioSeleccionado) {
            case "patente":
                this.setLstCars(carService.findByPatente(criterioBusqueda));

                break;
            case "marca":
                this.setLstCars(carService.findByMarca(criterioBusqueda));
                break;
            case "modelo":
                this.setLstCars(carService.findByModelo(criterioBusqueda));

                break;
            case "todos":
                this.setLstCars(carService.findAll());

                break;

        }
        if (criterioSeleccionado == null) {
            throw new BusinessException("Debe seleccionar un criterio de busqueda");
        }
        if (criterioBusqueda == null && !criterioSeleccionado.equals("todos")) {
            throw new BusinessException("Debe ingresar dato para buscar");
        }

        //this.setVotador(votanteService.findByDNI(dni));
    }

    public void vincularAutoDirigente() {

        if (lstPastorCar.contains(car)) {
            throw new BusinessException("El vehiculo que intenta agregar ya se encuentra vinculado al dirigente.");
        } else {
            lstPastorCar.add(car);
        }
         this.setBtVincular(Boolean.FALSE);

    }

    public void confirmarVinculacionAutoDirigente() {
        pastorCar = new PastorCar();

        Iterator<Car> it = lstPastorCar.iterator();
        while (it.hasNext()) {
            car = it.next();
            pastorCar.setPastor(pastorSelect);
            pastorCar.setCar(car);

            pastorCar.setIsActive(true);
            pastorCarService.insert(pastorCar);

        }
        if (lstPastorCar.size() > 1) {
            addDetailMessage(lstPastorCar.size() + " vehiculos han sido vinculados!");
        } else {
            addDetailMessage("El vehiculo ha sido vinculado!");
        }
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Auto Seleccionado", ((Car) event.getObject()).getPatente());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setDtAutosVinculados(Boolean.FALSE);

    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Auto deseleccionado", ((Car) event.getObject()).getPatente());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        setDtAutosVinculados(Boolean.TRUE);
    }

    public List<Car> getSelectedCars() {
        return selectedCars;
    }

    public List<Car> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Car> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }

    public LazyDataModel<Car> getCars() {
        return cars;
    }

    public void setCars(LazyDataModel<Car> cars) {
        this.cars = cars;
    }

    public Filter<Car> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Car> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public PastorCarFacadeLocal getPastorCarFacadeLocal() {
        return pastorCarFacadeLocal;
    }

    public void setPastorCarFacadeLocal(PastorCarFacadeLocal pastorCarFacadeLocal) {
        this.pastorCarFacadeLocal = pastorCarFacadeLocal;
    }

    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(String criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public String getCriterioBusqueda() {
        return criterioBusqueda;
    }

    public void setCriterioBusqueda(String criterioBusqueda) {
        this.criterioBusqueda = criterioBusqueda;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public PastorCar getPastorCar() {
        return pastorCar;
    }

    public void setPastorCar(PastorCar pastorCar) {
        this.pastorCar = pastorCar;
    }

    public Pastor getPastorSelect() {
        return pastorSelect;
    }

    public void setPastorSelect(Pastor pastorSelect) {
        this.pastorSelect = pastorSelect;
    }

    public List<Car> getLstPastorCar() {
        return lstPastorCar;
    }

    public void setLstPastorCar(List<Car> lstPastorCar) {
        this.lstPastorCar = lstPastorCar;
    }

    public List<Car> getLstCars() {
        return lstCars;
    }

    public void setLstCars(List<Car> lstCars) {
        this.lstCars = lstCars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean getDtAutosVinculados() {
        return dtAutosVinculados;
    }

    public void setDtAutosVinculados(Boolean dtAutosVinculados) {
        this.dtAutosVinculados = dtAutosVinculados;
    }

    public List<PadronVv> getLstVotantesAuto() {
        return lstVotantesAuto;
    }

    public void setLstVotantesAuto(List<PadronVv> lstVotantesAuto) {
        this.lstVotantesAuto = lstVotantesAuto;
    }

    public PastorCarService getPastorCarService() {
        return pastorCarService;
    }

    public void setPastorCarService(PastorCarService pastorCarService) {
        this.pastorCarService = pastorCarService;
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

}
