/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.mbeans;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import he1.seguridades.entities.nuevos.SegSoftwareBitacora;
import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.SegSoftwareBitacoraFacade;
import he1.utilities.SesionSeguridades;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@ManagedBean(name = "consulta")
@RequestScoped
public class JSFManagedBeanConsultaBitacora implements Serializable {

    @EJB
    private SegSoftwareBitacoraFacade segSoftwareBitacoraFacade;
    private SegSoftwareBitacora ssb = new SegSoftwareBitacora();
    private List<SegSoftwareBitacora> lsobtwarebitacora = new ArrayList<>();
    @EJB
    private SesionSeguridades sesionSeguridades;

    private String area = "";

    private String parametro = "";
    private VUsuariosClasif findByCedulaLogin = new VUsuariosClasif();

    @PostConstruct
    private void init() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            findByCedulaLogin = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
            if (findByCedulaLogin.getId() != null) {
                listaConsultaBitacora = sesionSeguridades.listaConsultaBitacora("-1", "-1");
            }

        } catch (Exception ex) {
            Logger.getLogger(JSFManagedBeanConsultaBitacora.class.getName()).log(Level.WARNING, null, ex);
        }

    }

    /**
     * Creates a new instance of JSFManagedBeanConsultaBitacora
     */
    public JSFManagedBeanConsultaBitacora() {
    }

    private List<Map> listaConsultaBitacora = new ArrayList<>();

    public void buttonAction(ActionEvent actionEvent) {
        try {

            if (findByCedulaLogin.getId() != null) {
                listaConsultaBitacora = sesionSeguridades.listaConsultaBitacora(parametro, area);
            }

        } catch (Exception ex) {
            Logger.getLogger(JSFManagedBeanConsultaBitacora.class.getName()).log(Level.WARNING, null, ex);
        }
    }

    /**
     * @return the parametro
     */
    public String getParametro() {
        return parametro;
    }

    /**
     * @param parametro the parametro to set
     */
    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    /**
     * @return the listaConsultaBitacora
     */
    public List<Map> getListaConsultaBitacora() {

        return listaConsultaBitacora;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the ssb
     */
    public SegSoftwareBitacora getSsb() {
        return ssb;
    }

    /**
     * @param ssb the ssb to set
     */
    public void setSsb(SegSoftwareBitacora ssb) {
        this.ssb = ssb;
    }

    /**
     * @return the lsobtwarebitacora
     */
    public List<SegSoftwareBitacora> getLsobtwarebitacora() {
        try {
            lsobtwarebitacora = segSoftwareBitacoraFacade.findAreasSistemas();
        } catch (Exception ex) {
            Logger.getLogger(JSFManagedBeanConsultaBitacora.class.getName()).log(Level.WARNING, null, ex);
        }

        return lsobtwarebitacora;
    }

}
