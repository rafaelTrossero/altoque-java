/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Candidatos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CandidatosFacadeLocal {

    void create(Candidatos candidatos);

    void edit(Candidatos candidatos);

    void remove(Candidatos candidatos);

    Candidatos find(Object id);

    List<Candidatos> findAll();

    List<Candidatos> findAllNacionales();

    List<Candidatos> findAllProvinciales();

    List<Candidatos> findAllByLugar(String lugar);

    List<Candidatos> findAllProvincialesByLugar(String lugar);

    List<Candidatos> findBycargo(String cargo);

    List<Candidatos> findRange(int[] range);

    int count();

    List<String> findCargos();

}
