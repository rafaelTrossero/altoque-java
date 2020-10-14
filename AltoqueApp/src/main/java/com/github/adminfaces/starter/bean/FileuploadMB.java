/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import org.primefaces.shaded.commons.io.IOUtils;

/**
 *
 * @author USUARIO
 */
@Model
public class FileuploadMB implements Serializable {

    private UploadedFile file;
    private UploadedFile uploadedFile;
   
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

   

    public void upload() {
        String fileName = uploadedFile.getFileName();
        System.out.println("-------------" +fileName);
        String contentType = uploadedFile.getContentType();
        byte[] contents = uploadedFile.getContents(); // Or getInputStream()
        // ... Save it, now!
    }

    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("handleFileUploadhandleFileUploadhandleFileUpload");
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded. Size (KB): " + event.getFile().getSize() / 1024f);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* "acta-Mesa1_019-08-11 00-28-3_F2.jpg"
    public void save(String imagenName) throws IOException {
        System.out.println("el nombre de la imagen es" + imagenName);
        System.out.println("file es ----" + file);
        // String filename = FilenameUtils.getName(file.getFileName());
        InputStream input = file.getInputstream();
        OutputStream output = new FileOutputStream(
               new File(configuracionesFacadeLocal.findAll().get(0).getRutaActas(), imagenName));

        try {
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }*/
}
