/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.mbeans;

import he1.seguridades.entities.SegUrls;
import he1.seguridades.entities.nuevos.PersonalNomina;
import he1.seguridades.entities.nuevos.SolicitudCertificado;
import he1.seguridades.entities.nuevos.TipoSolicitud;
import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.PersonalNominaFacade;
import he1.seguridades.sessions.SegUrlsFacade;
import he1.seguridades.sessions.SolicitudCertificadoFacade;
import he1.seguridades.sessions.TipoSolicitudFacade;
import he1.seguridades.sessions.VUsuariosClasifFacade;
import he1.utilities.SesionSeguridades;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@ManagedBean
@ViewScoped
public class JSFManagedBeanSolicitudes implements Serializable {

    @EJB
    private SesionSeguridades sesionSeguridades;

    @EJB
    private SegUrlsFacade segUrlsFacade;

    @EJB
    private PersonalNominaFacade personalNominaFacade;

    @EJB
    private TipoSolicitudFacade tipoSolicitudFacade;
    @EJB
    private SolicitudCertificadoFacade solicitudCertificadoFacade;
    private List<SolicitudCertificado> lsolicitudes = new ArrayList<SolicitudCertificado>();
    private List<SolicitudCertificado> lsolicitudes2 = new ArrayList<SolicitudCertificado>();
    private List<SolicitudCertificado> lsolicitudes3 = new ArrayList<SolicitudCertificado>();
    private SolicitudCertificado certificado = new SolicitudCertificado();

    @EJB
    private VUsuariosClasifFacade vUsuariosClasifFacade;
    VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();

    /**
     * Creates a new instance of JSFManagedBeanSolicitudes
     */
    public JSFManagedBeanSolicitudes() {
    }
    private PersonalNomina pParSolicitudes = new PersonalNomina();

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
        //lista de todas las solicitudes
        setpParSolicitudes(personalNominaFacade.find(new Long(vUsuariosClasif.getNomId().toString())));
        lsolicitudes = solicitudCertificadoFacade.findSolicitudes(getpParSolicitudes());
        lsolicitudes2 = solicitudCertificadoFacade.findSolicitudes2(getpParSolicitudes());
        lsolicitudes3 = solicitudCertificadoFacade.findSolicitudes3(getpParSolicitudes());

    }

    /**
     * @return the lsolicitudes
     */
    public List<SolicitudCertificado> getLsolicitudes() {
        return lsolicitudes;
    }

    /**
     * @param lsolicitudes the lsolicitudes to set
     */
    public void setLsolicitudes(List<SolicitudCertificado> lsolicitudes) {
        this.lsolicitudes = lsolicitudes;
    }

    /**
     * @return the pParSolicitudes
     */
    public PersonalNomina getpParSolicitudes() {
        return pParSolicitudes;
    }

    /**
     * @param pParSolicitudes the pParSolicitudes to set
     */
    public void setpParSolicitudes(PersonalNomina pParSolicitudes) {
        this.pParSolicitudes = pParSolicitudes;
    }

    /**
     * @return the certificado
     */
    public SolicitudCertificado getCertificado() {
        return certificado;
    }

    /**
     * @param certificado the certificado to set
     */
    public void setCertificado(SolicitudCertificado certificado) {
        this.certificado = certificado;
    }

    public String grabar() {
        try {
            SolicitudCertificado solicitudCertificado = new SolicitudCertificado();
            solicitudCertificado.setId(BigDecimal.ONE);
            solicitudCertificado.setPersonalNomina(pParSolicitudes);
            solicitudCertificado.setSlcObservacion(certificado.getSlcObservacion().toUpperCase());
            TipoSolicitud tipoSolicitud = new TipoSolicitud();
            TipoSolicitud tsol = tipoSolicitudFacade.find(new BigDecimal("1"));
            solicitudCertificado.setTipoSolicitud(tsol);
            Date d = new Date();
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
            solicitudCertificado.setSlcFechaSolicitud(d);
            solicitudCertificadoFacade.create(solicitudCertificado);

            lsolicitudes = solicitudCertificadoFacade.findSolicitudes(getpParSolicitudes());
            lsolicitudes2 = solicitudCertificadoFacade.findSolicitudes2(getpParSolicitudes());
            lsolicitudes3 = solicitudCertificadoFacade.findSolicitudes3(getpParSolicitudes());

        } catch (Exception e) {
            addMessage("Solo puede agregar una solicitud por día");
        }
        certificado = new SolicitudCertificado();
        return null;
    }

    public String grabar2() {
        try {
            SolicitudCertificado solicitudCertificado = new SolicitudCertificado();
            solicitudCertificado.setId(BigDecimal.ONE);
            solicitudCertificado.setPersonalNomina(pParSolicitudes);
            solicitudCertificado.setSlcObservacion(certificado.getSlcObservacion().toUpperCase());
            TipoSolicitud tipoSolicitud = new TipoSolicitud();
            TipoSolicitud tsol = tipoSolicitudFacade.find(new BigDecimal("2"));
            solicitudCertificado.setTipoSolicitud(tsol);
            Date d = new Date();
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
            solicitudCertificado.setSlcFechaSolicitud(d);
            solicitudCertificadoFacade.create(solicitudCertificado);

            lsolicitudes = solicitudCertificadoFacade.findSolicitudes(getpParSolicitudes());
            lsolicitudes2 = solicitudCertificadoFacade.findSolicitudes2(getpParSolicitudes());
            lsolicitudes3 = solicitudCertificadoFacade.findSolicitudes3(getpParSolicitudes());

            //habilitar el boton de impresión
            habilitaImprime = true;
        } catch (Exception e) {
            addMessage("Solo puede agregar una solicitud de un tipo por día");
        }
        certificado = new SolicitudCertificado();
        return null;
    }

    public String grabar3() {
        try {
            SolicitudCertificado solicitudCertificado = new SolicitudCertificado();
            solicitudCertificado.setId(BigDecimal.ONE);
            solicitudCertificado.setPersonalNomina(pParSolicitudes);
            solicitudCertificado.setSlcObservacion(certificado.getSlcObservacion().toUpperCase());
            TipoSolicitud tipoSolicitud = new TipoSolicitud();
            TipoSolicitud tsol = tipoSolicitudFacade.find(new BigDecimal("3"));
            solicitudCertificado.setTipoSolicitud(tsol);
            Date d = new Date();
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
            solicitudCertificado.setSlcFechaSolicitud(d);
            solicitudCertificadoFacade.create(solicitudCertificado);

            lsolicitudes = solicitudCertificadoFacade.findSolicitudes(getpParSolicitudes());
            lsolicitudes2 = solicitudCertificadoFacade.findSolicitudes2(getpParSolicitudes());
            lsolicitudes3 = solicitudCertificadoFacade.findSolicitudes3(getpParSolicitudes());

        } catch (Exception e) {
            addMessage("Solo puede agregar una solicitud por día");
        }
        certificado = new SolicitudCertificado();
        return null;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the lsolicitudes2
     */
    public List<SolicitudCertificado> getLsolicitudes2() {
        return lsolicitudes2;
    }

    /**
     * @param lsolicitudes2 the lsolicitudes2 to set
     */
    public void setLsolicitudes2(List<SolicitudCertificado> lsolicitudes2) {
        this.lsolicitudes2 = lsolicitudes2;
    }

    /**
     * @return the lsolicitudes3
     */
    public List<SolicitudCertificado> getLsolicitudes3() {
        return lsolicitudes3;
    }

    /**
     * @param lsolicitudes3 the lsolicitudes3 to set
     */
    public void setLsolicitudes3(List<SolicitudCertificado> lsolicitudes3) {
        this.lsolicitudes3 = lsolicitudes3;
    }
    private boolean habilitaImprime = false;

    public void buttonActionImprime(ActionEvent actionEvent) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

            SegUrls findURL = segUrlsFacade.findURL("rep solicitud Certif firma digital");
            ec.redirect(findURL.getUrl());
        } catch (Exception e) {
            System.out.println("e = " + e.getLocalizedMessage());
        }

    }

    /**
     * @return the habilitaImprime
     */
    public boolean isHabilitaImprime() {
////        try {
////            List data = new ArrayList<HashMap>();
////
////            HashMap resultMap = new HashMap();
////            data = sesionSeguridades.findTieneSolicitudFirmaDigitalHoy(vUsuariosClasif.getNomId().toString());
//////            resultMap = (HashMap) data.get(0);
////            String valorRetornado = resultMap.get("TOTAL").toString();
////
////            if (valorRetornado.equalsIgnoreCase("0")) {
////                habilitaImprime = false;
////
////            } else {
////                habilitaImprime = true;
////            }
////        } catch (Exception ex) {
////            Logger.getLogger(JSFManagedBeanSolicitudes.class.getName()).log(Level.WARNING, null, ex);
////        }
        return habilitaImprime;
    }

    /**
     * @param habilitaImprime the habilitaImprime to set
     */
    public void setHabilitaImprime(boolean habilitaImprime) {
        this.habilitaImprime = habilitaImprime;
    }
}
