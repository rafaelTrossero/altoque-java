/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.PadronVv;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorVotante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface PastorVotanteFacadeLocal {

    void create(PastorVotante pastorVotante);

    void edit(PastorVotante pastorVotante);

    void remove(PastorVotante pastorVotante);
    
     void removeByPastor(Pastor pastor);

    PastorVotante find(Object id);
    
    List<PastorVotante> findByVotanteYpastor(Pastor pastor, PadronVv votante);

    List<PastorVotante> findAll();

    List<PastorVotante> findRange(int[] range);

    int count();
    
     List<PadronVv> findVotantesByPastor(Pastor pastor);
    
    
}
