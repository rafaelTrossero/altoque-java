/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.FiscalActasFacadeLocal;
import DAO.FiscalFacadeLocal;
import DAO.MesaDistritoFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.FiscalActas;
import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author rat_5
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class FiscalActaService implements Serializable {

    
    List<FiscalActas> allFiscalActas;
    
     List<FiscalActas> allFiscalActasCargadas;
     
      List<FiscalActas> allFiscalActasManual;

    @EJB
    private FiscalActasFacadeLocal fiscalActasFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall
    
    @EJB
    private MesaDistritoFacadeLocal mesaDistritoFacadeLocal;

    public List<FiscalActas> getAllFiscalActas() {
        return allFiscalActas;
    }

    public void setAllFiscalActas(List<FiscalActas> allFiscalActas) {
        this.allFiscalActas = allFiscalActas;
    }

    public FiscalActasFacadeLocal getFiscalActasFacadeLocal() {
        return fiscalActasFacadeLocal;
    }

    public void setFiscalActasFacadeLocal(FiscalActasFacadeLocal fiscalActasFacadeLocal) {
        this.fiscalActasFacadeLocal = fiscalActasFacadeLocal;
    }

    public List<FiscalActas> getAllFiscalActasCargadas() {
        return allFiscalActasCargadas;
    }

    public void setAllFiscalActasCargadas(List<FiscalActas> allFiscalActasCargadas) {
        this.allFiscalActasCargadas = allFiscalActasCargadas;
    }

    public MesaDistritoFacadeLocal getMesaDistritoFacadeLocal() {
        return mesaDistritoFacadeLocal;
    }

    public void setMesaDistritoFacadeLocal(MesaDistritoFacadeLocal mesaDistritoFacadeLocal) {
        this.mesaDistritoFacadeLocal = mesaDistritoFacadeLocal;
    }

    public List<FiscalActas> getAllFiscalActasManual() {
        return allFiscalActasManual;
    }

    public void setAllFiscalActasManual(List<FiscalActas> allFiscalActasManual) {
        this.allFiscalActasManual = allFiscalActasManual;
    }

   

    public List<FiscalActas> paginate(Filter<FiscalActas> filter) {
        List<FiscalActas> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

            cargarActasNoCargadas();

            pagedCars = allFiscalActas.stream().
                    sorted((c1, c2) -> {
                        if (filter.getSortOrder().isAscending()) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
        }

        int page = filter.getFirst() + filter.getPageSize();
        if (filter.getParams().isEmpty()) {
            pagedCars = pagedCars.subList(filter.getFirst(), page > allFiscalActas.size() ? allFiscalActas.size() : page);
            return pagedCars;
        }

        List<Predicate<FiscalActas>> predicates = configFilter(filter);

        List<FiscalActas> pagedList = allFiscalActas.stream().filter(predicates
                .stream().reduce(Predicate::or).orElse(t -> true))
                .collect(Collectors.toList());

        if (page < pagedList.size()) {
            pagedList = pagedList.subList(filter.getFirst(), page);
        }

        if (has(filter.getSortField())) {
            pagedList = pagedList.stream().
                    sorted((c1, c2) -> {
                        boolean asc = SortOrder.ASCENDING.equals(filter.getSortOrder());
                        if (asc) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
        }
        return pagedList;
    }

    private List<Predicate<FiscalActas>> configFilter(Filter<FiscalActas> filter) {
        List<Predicate<FiscalActas>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<FiscalActas> idPredicate = (FiscalActas c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(FiscalActas fiscalActas) {
        try {
            validate(fiscalActas);

            allFiscalActas.add(fiscalActas);
            fiscalActasFacadeLocal.create(fiscalActas);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validate(FiscalActas fiscal) {
        BusinessException be = new BusinessException();
        /*if (!fiscal.hasApeNom()) {
            be.addException(new BusinessException("Nombre cannot be empty"));
        }
        if (!fiscal.hasTel()) {
            be.addException(new BusinessException("Apellido cannot be empty"));
        }
        if (!fiscal.hasChatId()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }
        if (!fiscal.hasMesa()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }

        if (has(be.getExceptionList())) {
            throw be;
        }*/
    }

    @RolesAllowed("ADMIN")
    public void remove(FiscalActas fiscalActas) {
        this.fiscalActasFacadeLocal.remove(fiscalActas);
        allFiscalActas.remove(fiscalActas);

    }

    public long count(Filter<FiscalActas> filter) {
        return allFiscalActas.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public FiscalActas findById(Integer id) {
        return allFiscalActas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("FiscalActas not found with id " + id));
    }

    @RolesAllowed("ADMIN")
    public void update(FiscalActas fiscalActas) {
        // validate(fiscal);
        allFiscalActas.remove(allFiscalActas.indexOf(fiscalActas));
        allFiscalActas.add(fiscalActas);
        fiscalActasFacadeLocal.edit(fiscalActas);

    }

    public void cargarActas() {
        try {
            this.setAllFiscalActas(this.fiscalActasFacadeLocal.findAll());
        } catch (Exception ex) {

        }
    }//fin cargarUsuari
    
      public void cargarActasNoCargadas() {
        try {
            this.setAllFiscalActas(this.fiscalActasFacadeLocal.findAllNoCargadas());
        } catch (Exception ex) {

        }
    }//fin cargarUsuari
      
        public void cargarActasCargadas() {
        try {
            this.setAllFiscalActasCargadas(this.fiscalActasFacadeLocal.findAllCargadas());
        } catch (Exception ex) {

        }
    }//fin cargarUsuari
        
         public void cargarActasManual() {
        try {
            this.setAllFiscalActasManual(this.fiscalActasFacadeLocal.findAllManual());
           
        } catch (Exception ex) {

        }
    }//fin cargarUsuari

}
