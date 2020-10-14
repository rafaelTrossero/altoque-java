/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import recursos.cadenas;
import DAO.PersonaFacadeLocal;
import com.github.adminfaces.starter.model.Persona;

/**
 *
 * @author RafaTrossero
 */
@Stateless
public class PersonaRN implements PersonaRNLocal {
    
    @EJB
    private PersonaFacadeLocal personaFacadeLocal;
    

    @Override
    public void create(Persona pro) throws Exception {
         this.convertir_strings(pro);
        this.validar(pro, 0);
        this.personaFacadeLocal.create(pro);
    }

    @Override
    public void remove(Persona pro) throws Exception {
    this.personaFacadeLocal.remove(pro);
    }

    @Override
    public void edit(Persona pro) throws Exception {
        this.convertir_strings(pro);
        this.validar(pro, 1);
    this.personaFacadeLocal.edit(pro);
    }

    @Override
    public List<Persona> findAll() throws Exception {
    return (this.personaFacadeLocal.findAll());
    }

    @Override
    public Persona findByDni(Integer dni) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activate(Persona persona, Boolean bEstado) throws Exception {
   personaFacadeLocal.activate(persona, bEstado);
    }

    @Override
    public List<Persona> findAllActivo() throws Exception {
     return(this.personaFacadeLocal.findAllActivo());
    }

  private void convertir_strings(Persona p) {
        p.setNombre(cadenas.convertir(p.getNombre()));
    }
      private void validar(Persona p, int op) throws Exception {
        //verifica si el código es menor o igual a cero
        

        //verifica si es una línea en blanco
        if (p.getNombre().trim().length() == 0) {
            throw new Exception("El nombre del persona no puede estar vacio");
        }
      //  if (p.getCuil().trim().length() == 0) {
       //     throw new Exception("El cuil del persona no puede estar vacio");
        //}
        
        if (!cadenas.es_numero(p.getDni())){ 
            throw new Exception("El DNI del persona no puede estar vacio");
        }
        if (!cadenas.es_letras(p.getNombre())) {
            throw new Exception("El nombre del persona debe contener solo caracteres alfabeticos");
        }
       
        
//Valida si contine letras
      
//         if (p.getDomicilio().getLocalidad() == null) {
  //          throw new Exception("Debe Ingresar la Localidad");
    //    }
         if (personaFacadeLocal.bFindByDni(p, op)) {
         throw new Exception("Ya existe un Persona con ese DNI");
         }
         if (personaFacadeLocal.bFindByCuil(p, op)) {
         throw new Exception("Ya existe un Persona con ese CUIT");
         }

    }//fin validar
}
