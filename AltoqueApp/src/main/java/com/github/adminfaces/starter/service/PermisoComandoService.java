/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.FiscalFacadeLocal;
import DAO.PermisosComandoFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.PermisosComando;
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
public class PermisoComandoService implements Serializable  {

    List<PermisosComando> allPermisosComando;

    @EJB
    private PermisosComandoFacadeLocal permisosComandoFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    public List<PermisosComando> getAllPermisosComando() {
        return allPermisosComando;
    }

    public void setAllPermisosComando(List<PermisosComando> allPermisosComando) {
        this.allPermisosComando = allPermisosComando;
    }

    

    public PermisosComandoFacadeLocal getPermisosComandoFacadeLocal() {
        return permisosComandoFacadeLocal;
    }

    public void setPermisosComandoFacadeLocal(PermisosComandoFacadeLocal permisosComandoFacadeLocal) {
        this.permisosComandoFacadeLocal = permisosComandoFacadeLocal;
    }


    public List<PermisosComando> paginate(Filter<PermisosComando> filter) {
        List<PermisosComando> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

           
            cargarPermisosComando();

            pagedCars = allPermisosComando.stream().
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
            pagedCars = pagedCars.subList(filter.getFirst(), page > allPermisosComando.size() ? allPermisosComando.size() : page);
            return pagedCars;
        }

        List<Predicate<PermisosComando>> predicates = configFilter(filter);

        List<PermisosComando> pagedList = allPermisosComando.stream().filter(predicates
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

    private List<Predicate<PermisosComando>> configFilter(Filter<PermisosComando> filter) {
        List<Predicate<PermisosComando>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<PermisosComando> idPredicate = (PermisosComando c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(PermisosComando permisosComando) {
        try {
            validate(permisosComando);

            allPermisosComando.add(permisosComando);
            permisosComandoFacadeLocal.create(permisosComando);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validate(PermisosComando permisosComando) {
        BusinessException be = new BusinessException();
    

        if (has(be.getExceptionList())) {
            throw be;
        }
    }

    @RolesAllowed("ADMIN")
    public void remove(PermisosComando permisosComando) {
       // permisosComando.setIsActive(Boolean.FALSE);
        this.permisosComandoFacadeLocal.edit(permisosComando);
       // allFiscales.remove(fiscal);

    }

    public long count(Filter<PermisosComando> filter) {
        return allPermisosComando.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public PermisosComando findById(Integer id) {
        return allPermisosComando.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("PermisosComando not found with id " + id));
    }

    @RolesAllowed("ADMIN")
    public void update(PermisosComando permisosComando) {
        validate(permisosComando);
        allPermisosComando.remove(allPermisosComando.indexOf(permisosComando));
        allPermisosComando.add(permisosComando);
        permisosComandoFacadeLocal.edit(permisosComando);

    }

    public void cargarPermisosComando() {
        try {
            this.setAllPermisosComando(this.permisosComandoFacadeLocal.findAll());
        } catch (Exception ex) {

        }
    }//fin cargarUsuari
   
}
