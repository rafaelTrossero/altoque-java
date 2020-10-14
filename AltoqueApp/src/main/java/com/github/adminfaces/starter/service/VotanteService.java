/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.PadronVvFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;

import com.github.adminfaces.template.exception.BusinessException;
import static com.github.adminfaces.template.util.Assert.has;
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
 * @author rat_5
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class VotanteService {

    List<PadronVv> allPadronVv;

    List<PadronVv> dniPadronVv;

    @EJB
    private PadronVvFacadeLocal padronVvFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public List<PadronVv> getAllPadronVv() {
        return allPadronVv;
    }

    public void setAllPadronVv(List<PadronVv> allPadronVv) {
        this.allPadronVv = allPadronVv;
    }

    public List<PadronVv> getDniPadronVv() {
        return dniPadronVv;
    }

    public void setDniPadronVv(List<PadronVv> dniPadronVv) {
        this.dniPadronVv = dniPadronVv;
    }

    public List<PadronVv> paginate(Filter<PadronVv> filter) {
        List<PadronVv> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

            cargarPadron();

            pagedCars = allPadronVv.stream().
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
            pagedCars = pagedCars.subList(filter.getFirst(), page > allPadronVv.size() ? allPadronVv.size() : page);
            return pagedCars;
        }

        List<Predicate<PadronVv>> predicates = configFilter(filter);

        List<PadronVv> pagedList = allPadronVv.stream().filter(predicates
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

    private List<Predicate<PadronVv>> configFilter(Filter<PadronVv> filter) {
        List<Predicate<PadronVv>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<PadronVv> idPredicate = (PadronVv c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(PadronVv votante) {
        try {

            allPadronVv.add(votante);

            padronVvFacadeLocal.create(votante);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long count(Filter<PadronVv> filter) {
        return allPadronVv.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public PadronVv findById(Integer id) {
        return allPadronVv.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("PadronVv not found with id " + id));
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public PadronVv findByDNI(Integer dni) {
        System.out.println("el dni en service es " + dni);
        System.out.println("votador esss " + padronVvFacadeLocal.findByDni(dni));
        return padronVvFacadeLocal.findByDni(dni);

    }
    
        public List<PadronVv> findByDNIList(Integer dni) {
       
        return padronVvFacadeLocal.findByDniList(dni);

    }

    public List<PadronVv> findByApenom(String apenom) {

        return padronVvFacadeLocal.findByApenom(apenom);

    }

    public List<PadronVv> findByOrden(String orden) {

        return padronVvFacadeLocal.findByOrden(Integer.parseInt(orden));

    }

    public PadronVv findByDNIPadron(Integer dni) {
        return dniPadronVv.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElseThrow(() -> new BusinessException("No hay coincidencias en el padron con el DNI:  " + dni));
    }

    @RolesAllowed("ADMIN")
    public void update(PadronVv votante) {

        allPadronVv.remove(allPadronVv.indexOf(votante));
        allPadronVv.add(votante);
        padronVvFacadeLocal.edit(votante);

    }

    @RolesAllowed("ADMIN")
    public void remove(PadronVv votante) {
        allPadronVv.remove(votante);
    }

    public void cargarPadron() {
        System.out.println("Entro a cargar Padron");
        try {
            this.setAllPadronVv(this.padronVvFacadeLocal.findAll());
            System.err.println("Padron en VOTANTE SERVICE es :::::::____" + allPadronVv);
        } catch (Exception ex) {

        }
    }//fin cargarUsuario
}
