/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author rat_5
 */
@Named(value = "chartBackBean")
@SessionScoped
public class ChartBackBean implements Serializable {

    /**
     * Creates a new instance of ChartBackBean
     */
    public ChartBackBean() {
    }
    
}
