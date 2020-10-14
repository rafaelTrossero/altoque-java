/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.FiscalFacadeLocal;
import DAO.PastorFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.Fiscal;

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

/**
 *
 * @author USUARIO
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class FiscalService implements Serializable  {

    List<Fiscal> allFiscales;

    @EJB
    private FiscalFacadeLocal fiscalFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public List<Fiscal> getAllFiscales() {
        return allFiscales;
    }

    public void setAllFiscales(List<Fiscal> allFiscales) {
        this.allFiscales = allFiscales;
    }

    public FiscalFacadeLocal getFiscalFacadeLocal() {
        return fiscalFacadeLocal;
    }

    public void setFiscalFacadeLocal(FiscalFacadeLocal fiscalFacadeLocal) {
        this.fiscalFacadeLocal = fiscalFacadeLocal;
    }

    public List<Fiscal> paginate(Filter<Fiscal> filter) {
        List<Fiscal> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

            cargarFiscales();

            pagedCars = allFiscales.stream().
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
            pagedCars = pagedCars.subList(filter.getFirst(), page > allFiscales.size() ? allFiscales.size() : page);
            return pagedCars;
        }

        List<Predicate<Fiscal>> predicates = configFilter(filter);

        List<Fiscal> pagedList = allFiscales.stream().filter(predicates
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

    private List<Predicate<Fiscal>> configFilter(Filter<Fiscal> filter) {
        List<Predicate<Fiscal>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Fiscal> idPredicate = (Fiscal c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(Fiscal fiscal) {
        try {
            validate(fiscal);
            fiscal.setIsActive(Boolean.TRUE);
            allFiscales.add(fiscal);
            fiscalFacadeLocal.create(fiscal);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validate(Fiscal fiscal) {
        BusinessException be = new BusinessException();
        if (!fiscal.hasApeNom()) {
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
        }
    }

    @RolesAllowed("ADMIN")
    public void remove(Fiscal fiscal) {
        fiscal.setIsActive(Boolean.FALSE);
        this.fiscalFacadeLocal.edit(fiscal);
       // allFiscales.remove(fiscal);

    }

    public long count(Filter<Fiscal> filter) {
        return allFiscales.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public Fiscal findById(Integer id) {
        return allFiscales.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("fiscal not found with id " + id));
    }

    @RolesAllowed("ADMIN")
    public void update(Fiscal fiscal) {
        validate(fiscal);
        allFiscales.remove(allFiscales.indexOf(fiscal));
        allFiscales.add(fiscal);
        fiscalFacadeLocal.edit(fiscal);

    }

    public void cargarFiscales() {
        try {
            this.setAllFiscales(this.fiscalFacadeLocal.findByIsActive());
        } catch (Exception ex) {

        }
    }//fin cargarUsuari
}
