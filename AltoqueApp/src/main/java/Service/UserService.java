/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import RN.UsuariosRNLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.model.SortOrder;

import Modelo.Usuarios;
import com.github.adminfaces.template.exception.BusinessException;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.github.adminfaces.template.util.Assert.has;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 * @author rmpestano User Business logic
 */
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class UserService implements Serializable {

    List<Usuarios> allUsers;

    @EJB
    private UsuariosRNLocal usuarioRNLocal;//hacemos la referencia para poder utilizar el metodo findall

    public List<Usuarios> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<Usuarios> allUsers) {
        this.allUsers = allUsers;
    }

    public List<Usuarios> paginate(Filter<Usuarios> filter) {
        List<Usuarios> pagedCars = new ArrayList<>();
        if (has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {

            cargarUsuario();

            pagedCars = allUsers.stream().
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
            pagedCars = pagedCars.subList(filter.getFirst(), page > allUsers.size() ? allUsers.size() : page);
            return pagedCars;
        }

        List<Predicate<Usuarios>> predicates = configFilter(filter);

        List<Usuarios> pagedList = allUsers.stream().filter(predicates
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

    private List<Predicate<Usuarios>> configFilter(Filter<Usuarios> filter) {
        List<Predicate<Usuarios>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Usuarios> idPredicate = (Usuarios c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        return predicates;
    }

    @RolesAllowed("ADMIN")
    public void insert(Usuarios user) {
        try {
            validate(user);
            System.out.println("com.github.adminfaces.starter.service.UserService.insert()" +user);
            allUsers.add(user);
             System.out.println("com.github.adminfaces.starter.service.UserService.insert()" +allUsers);
            usuarioRNLocal.create(user);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validate(Usuarios user) {
        BusinessException be = new BusinessException();
        if (!user.hasNombre()) {
            be.addException(new BusinessException("Nombre cannot be empty"));
        }
        if (!user.hasApellido()) {
            be.addException(new BusinessException("Apellido cannot be empty"));
        }
        if (!user.hasTipo()) {
            be.addException(new BusinessException("Tipo de usuario cannot be empty"));
        }
        if (!user.hasUsuario()) {
            be.addException(new BusinessException("Nombre de usuario cannot be empty"));
        }

        if (allUsers.stream().filter(c -> c.getUsuario().equalsIgnoreCase(user.getUsuario())
                && c.getId() != user.getId()).count() > 0) {
            be.addException(new BusinessException("username must be unique"));
        }
        if (has(be.getExceptionList())) {
            throw be;
        }
    }

    @RolesAllowed("ADMIN")
    public void remove(Usuarios user) {
        user.setIsActive(Boolean.FALSE);
        this.usuarioRNLocal.edit(user);
        //allUsers.remove(user);
        
    }

    public long count(Filter<Usuarios> filter) {
        return allUsers.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    // uncomment annotation below and try invoking find by ID in list page with non admin user 
    //@RolesAllowed("ADMIN")
    public Usuarios findById(Integer id) {
        return allUsers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("User not found with id " + id));
    }

    @RolesAllowed("ADMIN")
    public void update(Usuarios user) {
        validate(user);
        allUsers.remove(allUsers.indexOf(user));
        allUsers.add(user);
        usuarioRNLocal.edit(user);

    }

    public void cargarUsuario() {
        try {
            this.setAllUsers(this.usuarioRNLocal.findUsuarios(null));
        } catch (Exception ex) {

        }
    }//fin cargarUsuario
}
