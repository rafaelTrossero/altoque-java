/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.ActaFacadeLocal;
import DAO.CarFacadeLocal;
import DAO.FiscalFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.starter.model.Acta;
import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import org.omnifaces.util.Faces;

/**
 * @author rmpestano Car Business logic
 */
@Stateless
public class ActaService implements Serializable {

    List<Acta> allActas;
    @Inject
    LogonMB logon;

    @EJB
    private ActaFacadeLocal actaFacadeLocal;

    public List<Acta> getAllActas() {
        return allActas;
    }

    public void setAllActas(List<Acta> allActas) {
        this.allActas = allActas;
    }

 
    public List<Acta> paginate(Filter<Acta> filter) {
        List<Acta> pagedActas = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {
            cargarActas();
            pagedActas = allActas.stream().
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
            pagedActas = pagedActas.subList(filter.getFirst(), page > allActas.size() ? allActas.size() : page);
            return pagedActas;
        }

        List<Predicate<Acta>> predicates = configFilter(filter);

        List<Acta> pagedList = allActas.stream().filter(predicates
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

    private List<Predicate<Acta>> configFilter(Filter<Acta> filter) {
        List<Predicate<Acta>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Acta> idPredicate = (Acta c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        /*
        if (has(filter.getEntity())) {
            Acta filterEntity = filter.getEntity();
            if (has(filterEntity.getId())) {
                Predicate<Car> modelPredicate = (Car c) -> c.getModel().toLowerCase().contains(filterEntity.getId());
                predicates.add(modelPredicate);
            }

       

            if (has(filterEntity.getName())) {
                Predicate<Car> namePredicate = (Car c) -> c.getName().toLowerCase().contains(filterEntity.getName().toLowerCase());
                predicates.add(namePredicate);
            }
        }*/
        return predicates;
    }

    public void insert(Acta acta) {
        //validate(car);  
System.out.println("el usuario essssss" +logon.getCurrentUser());
       // allActas.add(acta);

       acta.setUsuario(logon.getCurrentUser());
        actaFacadeLocal.create(acta);

    }

    public void validate(Acta acta) {
        /*
        BusinessException be = new BusinessException();
        if (!car.hasModel()) {
            be.addException(new BusinessException("Car model cannot be empty"));
        }*/

    }

    public void remove(Acta acta) {
        allActas.remove(acta);
        actaFacadeLocal.remove(acta);
    }

    public long count(Filter<Acta> filter) {
        return allActas.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    public Acta findById(Long id) {
        return allActas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("Acta not found with id " + id));
    }

    public void update(Acta acta) {
        validate(acta);
        allActas.remove(allActas.indexOf(acta));
        allActas.add(acta);
        actaFacadeLocal.edit(acta);
    }

    public void cargarActas() {
        try {
            this.setAllActas(this.actaFacadeLocal.findAll());

        } catch (Exception ex) {

        }
    }//fin cargarUsuari

    public List<Acta> findAll() {
        return actaFacadeLocal.findAll();
    }
}
