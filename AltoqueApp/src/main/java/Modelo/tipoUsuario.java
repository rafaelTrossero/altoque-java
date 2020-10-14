/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author gio
 */
public enum tipoUsuario {
    
   
    ADMINISTRADOR("ADMINISTRADOR"),
    USER("USER");
    
    
    private String name;

    private tipoUsuario(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


