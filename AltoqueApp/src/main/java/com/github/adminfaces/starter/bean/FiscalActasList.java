/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.ConfiguracionesFacadeLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.FiscalActas;
import com.github.adminfaces.starter.service.FiscalActaService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import com.github.adminfaces.template.exception.BusinessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.primefaces.shaded.commons.io.IOUtils;

/**
 *
 * @author rat_5
 */
@Named
@ViewScoped
public class FiscalActasList implements Serializable {

    @Inject
    FiscalActaService fiscalActaService;

    @Inject
    FileuploadMB fileuploadMB;

    private UploadedFile uploadedFile;
    @EJB
    private ConfiguracionesFacadeLocal configuracionesFacadeLocal;

    Integer id;
    Integer mesanueva;
    String tipo;
    Boolean cargoTipo;
    String BOT_TOKEN = "https://api.telegram.org/file/bot725778184:AAFlC7rEcHf83IdD2wLHiS3VqyMIpFCAnvc";

    LazyDataModel<FiscalActas> fiscalActas;

    FiscalActas selectedFiscalActa;
    FiscalActas actaManual;
    Filter<FiscalActas> filter = new Filter<>(new FiscalActas());

    List<FiscalActas> selectedFiscalActas; //cars selected in checkbox column

    List<FiscalActas> lstFiscalActas;
    List<FiscalActas> lstFiscalActasManual;
    List<FiscalActas> lstFiscalActasCargadas;
    List<FiscalActas> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {

        this.actaManual = new FiscalActas();
        this.fiscalActaService.cargarActasNoCargadas();
        this.fiscalActaService.cargarActasCargadas();
        this.fiscalActaService.cargarActasManual();
        this.fiscalActaService.cargarActasManual();
        this.setLstFiscalActas(fiscalActaService.getAllFiscalActas());
        this.setLstFiscalActasCargadas(fiscalActaService.getAllFiscalActasCargadas());
        this.setLstFiscalActasManual(fiscalActaService.getAllFiscalActasManual());
        this.tipo = new String();
        this.cargoTipo = new Boolean(Boolean.TRUE);

    }

    public void clear() {
        filter = new Filter<FiscalActas>(new FiscalActas());
    }

    public void findFiscalById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide fiscalActaS ID to load");
        }
        selectedFiscalActas.add(fiscalActaService.findById(id));
    }

    public void delete() {
        int i = 0;
        for (FiscalActas selectedFiscalActas : selectedFiscalActas) {
            i++;
            fiscalActaService.remove(selectedFiscalActas);
        }
        selectedFiscalActas.clear();
        addDetailMessage(i + " FiscalActas deleted successfully!");
    }

    public void cambiarMesa() {

        System.err.println("mesa actual" + selectedFiscalActa.getMesa());
        System.err.println("mesa nueva" + mesanueva);

        selectedFiscalActa.setMesa(mesanueva);

        fiscalActaService.update(selectedFiscalActa);
        addDetailMessage("N° de Mesa modificado Correctamente!");

    }

    public void validarActa() {
        System.err.println("tipooo es" + tipo);
        if (tipo != null) {
            selectedFiscalActa.setIsValidated(Boolean.TRUE);
            selectedFiscalActa.setTipo(tipo);
            if (tipo == "nacional") {
                if (selectedFiscalActa.getMesa() >= 747 && selectedFiscalActa.getMesa() <= 754 || selectedFiscalActa.getMesa() == 789) {

                    selectedFiscalActa.setTipo("aconquija");
                    System.err.println("seteo tiopo ACONQUIJA" + tipo);
                }
            }

            fiscalActaService.update(selectedFiscalActa);
            addDetailMessage("Acta validad Correctamente!");
        } else {
            addDetailMessage("!!!!ERROR Debe seleccionar si el Acta es Provincial o Nacional!!!! Volver a validar ACTA N°" + selectedFiscalActa.getId(), FacesMessage.SEVERITY_FATAL);
        }
    }

    public void cargarTipo() {
        this.setCargoTipo(Boolean.FALSE);
    }

    public void upload() {
        String fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        byte[] contents = uploadedFile.getContents(); // Or getInputStream()
        // ... Save it, now!
        System.out.println("el archoasdadasdasd ess" +fileName);
        
    }

    public void cargarActaManual() {

        Timestamp ts = new Timestamp(Calendar.getInstance().getTime().getTime());

        System.out.println("tipo es:" + tipo + "LA FECHA ES " + ts);
        if (tipo != null) {
            System.out.println("1");
            if (tipo.equals("provincial")) {
                System.out.println("2");
                System.out.println("la mesa es" + actaManual.getMesa());
                String distrito = fiscalActaService.getMesaDistritoFacadeLocal().findByMesa(actaManual.getMesa()).getDistrito();
                System.out.println("el distrito es" + distrito);
                if (distrito != null) {
                    actaManual.setIsValidated(Boolean.TRUE);
                    actaManual.setTipo(distrito);
                }

            } else {
                actaManual.setIsValidated(Boolean.TRUE);
                actaManual.setTipo(tipo);
            }
            actaManual.setImagen("acta-Mesa" + actaManual.getMesa() + "_" + ts.toString().substring(1, 18).replace(":", "-") + "_Fmanual" + ".jpg");
            actaManual.setIsManual(Boolean.TRUE);
            System.out.println("imagen ess-----   " + actaManual.getImagen());
            fiscalActaService.insert(actaManual);

            try {

                save(actaManual.getImagen());
            } catch (IOException ex) {
                addDetailMessage("!!!!ERROR al guardar imagen ", FacesMessage.SEVERITY_FATAL);

                Logger.getLogger(FiscalActasList.class.getName()).log(Level.SEVERE, null, ex);
            }
            addDetailMessage("Acta cargada Correctamente!");
           
        } else {
            addDetailMessage("!!!!ERROR Debe seleccionar si el Acta es Provincial o Nacional!!!! Volver a cargar ACTA ", FacesMessage.SEVERITY_FATAL);
        }
    }
    
    public void save(String imagenName) throws IOException {
        System.out.println("el nombre de la imagen es" + imagenName);
        System.out.println("file es ----" + uploadedFile);
        // String filename = FilenameUtils.getName(file.getFileName());
        InputStream input = uploadedFile.getInputstream();
        OutputStream output = new FileOutputStream(
                new File(configuracionesFacadeLocal.findAll().get(0).getRutaActas(), imagenName));

        try {
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }

    public FiscalActaService getFiscalActaService() {
        return fiscalActaService;
    }

    public void setFiscalActaService(FiscalActaService fiscalActaService) {
        this.fiscalActaService = fiscalActaService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LazyDataModel<FiscalActas> getFiscalActas() {
        return fiscalActas;
    }

    public void setFiscalActas(LazyDataModel<FiscalActas> fiscalActas) {
        this.fiscalActas = fiscalActas;
    }

    public Filter<FiscalActas> getFilter() {
        return filter;
    }

    public void setFilter(Filter<FiscalActas> filter) {
        this.filter = filter;
    }

    public List<FiscalActas> getSelectedFiscalActas() {
        return selectedFiscalActas;
    }

    public void setSelectedFiscalActas(List<FiscalActas> selectedFiscalActas) {
        this.selectedFiscalActas = selectedFiscalActas;
    }

    public List<FiscalActas> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<FiscalActas> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public FiscalActas getSelectedFiscalActa() {
        return selectedFiscalActa;
    }

    public void setSelectedFiscalActa(FiscalActas selectedFiscalActa) {
        this.selectedFiscalActa = selectedFiscalActa;
    }

    public String getBOT_TOKEN() {
        return BOT_TOKEN;
    }

    public void setBOT_TOKEN(String BOT_TOKEN) {
        this.BOT_TOKEN = BOT_TOKEN;
    }

    public List<FiscalActas> getLstFiscalActas() {
        return lstFiscalActas;
    }

    public void setLstFiscalActas(List<FiscalActas> lstFiscalActas) {
        this.lstFiscalActas = lstFiscalActas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getCargoTipo() {
        return cargoTipo;
    }

    public void setCargoTipo(Boolean cargoTipo) {
        this.cargoTipo = cargoTipo;
    }

    public Integer getMesanueva() {
        return mesanueva;
    }

    public void setMesanueva(Integer mesanueva) {
        this.mesanueva = mesanueva;
    }

    public List<FiscalActas> getLstFiscalActasCargadas() {
        return lstFiscalActasCargadas;
    }

    public void setLstFiscalActasCargadas(List<FiscalActas> lstFiscalActasCargadas) {
        this.lstFiscalActasCargadas = lstFiscalActasCargadas;
    }

    public FiscalActas getActaManual() {
        return actaManual;
    }

    public void setActaManual(FiscalActas actaManual) {
        this.actaManual = actaManual;
    }

    public FileuploadMB getFileuploadMB() {
        return fileuploadMB;
    }

    public void setFileuploadMB(FileuploadMB fileuploadMB) {
        this.fileuploadMB = fileuploadMB;
    }

    public List<FiscalActas> getLstFiscalActasManual() {
        return lstFiscalActasManual;
    }

    public void setLstFiscalActasManual(List<FiscalActas> lstFiscalActasManual) {
        this.lstFiscalActasManual = lstFiscalActasManual;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
