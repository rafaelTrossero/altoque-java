/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.service;

import DAO.PadronVvFacadeLocal;
import DAO.PastorFacadeLocal;
import DAO.PastorVotanteFacadeLocal;
import RN.UsuariosRNLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.Usuarios;
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
import javax.faces.model.SelectItem;

/**
 *
 * @author USUARIO
 */
@Stateless
@RolesAllowed({"ADMIN","USER"})
public class PastorService {
   
    List<Pastor> allPastores;
     private List<SelectItem> lstSIPastores;

    @EJB
    private PastorFacadeLocal pastorFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall

    @EJB
    private PadronVvFacadeLocal padronVvFacadeLocal;
    
     @EJB
    private PastorVotanteFacadeLocal pastorVotanteFacadeLocal;
     
    public List<Pastor> getAllPastores() {
        return allPastores;
    }

    public void setAllPastores(List<Pastor> allPastores) {
        this.allPastores = allPastores;
    }

    public List<SelectItem> getLstSIPastores() {
        return lstSIPastores;
    }

    public void setLstSIPastores(List<SelectItem> lstSIPastores) {
        this.lstSIPastores = lstSIPastores;
    }

  

    public List<Pastor> paginate(Filter<Pastor> filter) {
        List<Pastor> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

            cargarPastores();
            

            pagedCars = allPastores.stream().
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
            pagedCars = pagedCars.subList(filter.getFirst(), page > allPastores.size() ? allPastores.size() : page);
            return pagedCars;
        }

        List<Predicate<Pastor>> predicates = configFilter(filter);

        List<Pastor> pagedList = allPastores.stream().filter(predicates
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

    private List<Predicate<Pastor>> configFilter(Filter<Pastor> filter) {
        List<Predicate<Pastor>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Pastor> idPredicate = (Pastor c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(Pastor pastor) {
        try {
            System.out.println("el pastor esssss" +pastor);
            System.out.println("el pastor esssss" +pastor.getApeNom());
            validate(pastor);
System.out.println("el pastor esssss" +pastor);
            allPastores.add(pastor);
            System.out.println("todos los pastor esssss" +allPastores);
            pastor.setIsActive(true);
            pastorFacadeLocal.create(pastor);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
    
    public void validate(Pastor pastor) {
        BusinessException be = new BusinessException();
        if (!pastor.hasApeNom()) {
            be.addException(new BusinessException("Nombre cannot be empty"));
        }
        if (!pastor.hasTel()) {
            be.addException(new BusinessException("Apellido cannot be empty"));
        }
        if (!pastor.hasDesc()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }
        

        if (has(be.getExceptionList())) {
            throw be;
        }
    }

    @RolesAllowed("ADMIN")
    public void remove(Pastor pastor) {
        pastor.setIsActive(Boolean.FALSE);
        this.pastorFacadeLocal.edit(pastor);
        //allPastores.remove(pastor);
        
    }

    public long count(Filter<Pastor> filter) {
        return allPastores.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public Pastor findById(Integer id) {
        return allPastores.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("dirigente not found with id " + id));
    }

    @RolesAllowed("ADMIN")
    public void update(Pastor pastor) {
        validate(pastor);
        allPastores.remove(allPastores.indexOf(pastor));
        allPastores.add(pastor);
        pastorFacadeLocal.edit(pastor);

    }

    public void cargarPastores() {
        try {
            System.err.println("entro a cargar pastores");
            this.setAllPastores(this.pastorFacadeLocal.findByIsActive(true));
            System.out.println("com.github.adminfaces.starter.service.PastorService.cargarPastores()" +allPastores);
        } catch (Exception ex) {

        }
    }//fin cargarUsuario

 public void cargar_SI_pastores() {
     System.err.println("entro a cargar SIIII pastores");
     
     this.setLstSIPastores(new ArrayList<SelectItem>());
       
     
        for (Pastor d : this.getAllPastores()) {
            SelectItem si = new SelectItem(d, d.getApeNom());
            this.getLstSIPastores().add(si);
            
        }
          System.err.println("el SI pastores esss:::::" +lstSIPastores);
     
       
    }//fin for

}
 

