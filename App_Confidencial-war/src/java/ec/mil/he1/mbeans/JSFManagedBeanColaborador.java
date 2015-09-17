/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.mbeans;

import he1.seguridades.entities.SegUrls;
import he1.seguridades.entities.nuevos.AcumulaDecimo;
import he1.seguridades.entities.nuevos.PersonalNomina;
import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.AcumulaDecimoFacade;
import he1.seguridades.sessions.PersonalNominaFacade;
import he1.seguridades.sessions.SegUrlsFacade;
import he1.utilities.SesionSeguridades;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@ManagedBean(name = "colaborador")
@ViewScoped
public class JSFManagedBeanColaborador implements Serializable {

    @EJB
    private SegUrlsFacade segUrlsFacade;

    @EJB
    private SesionSeguridades sesionSeguridades;

    @EJB
    private AcumulaDecimoFacade acumulaDecimoFacade;
    private AcumulaDecimo acumulaDecimo = new AcumulaDecimo();
    private List<AcumulaDecimo> lacumula = new ArrayList<>();

    @EJB
    private PersonalNominaFacade personalNominaFacade;
    private PersonalNomina personalNomina = new PersonalNomina();

    private String habilitaDecimos = "1";

    private String direccionReporteAcumulaDecimos = "";

    /**
     * s
     * Creates a new instance of JSFManagedBeanColaborador
     */
    public JSFManagedBeanColaborador() {

    }
    VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();
    String anio = "";

    @PostConstruct
    public void init() {
        try {
            anio = sesionSeguridades.findAnioActual();
            //aca se contiene la colección de valores en este caso si/no
            sino = new ArrayList<>();
            sino.add("SÍ");
            sino.add("NO");

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

            vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");
            //obtengo datos de personal(NOMINA)
            personalNomina = personalNominaFacade.find(new Long(vUsuariosClasif.getNomId().toString()));

            //la primera vez la lista no debe contener valores
            lacumula = acumulaDecimoFacade.findBuscaPorIdAcumula(vUsuariosClasif.getNomId().toString(), new BigInteger(anio));

            String data = "";

            data = sesionSeguridades.findFechasAcumulaDecimos(vUsuariosClasif.getNomId().toString());

            if (data.equalsIgnoreCase("NO PUEDE EDITAR EL REGISTRO")) {
                habilitaDecimos = "0";
            } else {
                habilitaDecimos = "1";
            }
            Iterator<AcumulaDecimo> iterator = lacumula.iterator();
            while (iterator.hasNext()) {
                AcumulaDecimo next = iterator.next();
                if (next.getTipo().equalsIgnoreCase("Decimo Tercer Sueldo")) {
                    decimotercer = next.getAccion();

                }
                if (next.getTipo().equalsIgnoreCase("Decimo Cuarto Sueldo")) {
                    decimocuarto = next.getAccion();

                }
            }

        } catch (Exception e) {
            System.out.println("e = " + e.getLocalizedMessage());
        }

    }

    private List<Map> listaAcumulaDecisiones = new ArrayList<>();

    public String getListabuscaautocomplete() {
        String data = "";
        //aca se coloca si se habilita la acumulación de décimos
        data = sesionSeguridades.findFechasAcumulaDecimos(vUsuariosClasif.getNomId().toString());
        return data;
    }

    /**
     * @return the personalNomina
     */
    public PersonalNomina getPersonalNomina() {
        return personalNomina;
    }

    /**
     * @param personalNomina the personalNomina to set
     */
    public void setPersonalNomina(PersonalNomina personalNomina) {
        this.personalNomina = personalNomina;
    }

    //
    private String decimotercer = "";
    private String decimocuarto = "";
    private List<String> sino = new ArrayList<String>();

    /**
     * @return the sino
     */
    public List<String> getSino() {
        return sino;
    }

    /**
     * @param sino the sino to set
     */
    public void setSino(List<String> sino) {
        this.sino = sino;
    }

    /**
     * @return the decimotercer
     */
    public String getDecimotercer() {
        return decimotercer;
    }

    /**
     * @param decimotercer the decimotercer to set
     */
    public void setDecimotercer(String decimotercer) {
        this.decimotercer = decimotercer;
    }

    /**
     * @return the decimocuarto
     */
    public String getDecimocuarto() {
        return decimocuarto;
    }

    /**
     * @param decimocuarto the decimocuarto to set
     */
    public void setDecimocuarto(String decimocuarto) {
        this.decimocuarto = decimocuarto;
    }

    public void listenDecimotercero(AjaxBehaviorEvent event) {

    }

    public void listenDecimocuarto(AjaxBehaviorEvent event) {

    }

    public void recuperar() {

        //la primera vez la lista no debe contener valores
        lacumula = acumulaDecimoFacade.findBuscaPorIdAcumula(vUsuariosClasif.getNomId().toString(), new BigInteger(anio));
    }

    public String buttonActionGrabar() {
        acumulaDecimoFacade.p_cambia_estado_decimos(vUsuariosClasif.getNomId().toString(), decimotercer, decimocuarto, anio);
        recuperar();
        addMessage("Su información se ha modificado correctamente");
        return null;
    }

    /**
     * @return the acumulaDecimo
     */
    public AcumulaDecimo getAcumulaDecimo() {
        return acumulaDecimo;
    }

    /**
     * @param acumulaDecimo the acumulaDecimo to set
     */
    public void setAcumulaDecimo(AcumulaDecimo acumulaDecimo) {
        this.acumulaDecimo = acumulaDecimo;
    }

    /**
     * @return the lacumula
     */
    public List<AcumulaDecimo> getLacumula() {
        return lacumula;
    }

    /**
     * @param lacumula the lacumula to set
     */
    public void setLacumula(List<AcumulaDecimo> lacumula) {
        this.lacumula = lacumula;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the listaAcumulaDecisiones
     */
    public List<Map> getListaAcumulaDecisiones() {
        return listaAcumulaDecisiones;
    }

    /**
     * @param listaAcumulaDecisiones the listaAcumulaDecisiones to set
     */
    public void setListaAcumulaDecisiones(List<Map> listaAcumulaDecisiones) {
        this.listaAcumulaDecisiones = listaAcumulaDecisiones;
    }

    /**
     * @return the habilitaDecimos
     */
    public String getHabilitaDecimos() {
        return habilitaDecimos;
    }

    /**
     * @param habilitaDecimos the habilitaDecimos to set
     */
    public void setHabilitaDecimos(String habilitaDecimos) {
        this.habilitaDecimos = habilitaDecimos;
    }

    public String imprimeAcumula() throws IOException {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

            SegUrls findURL = segUrlsFacade.findURL("imprimeacumula");
            ec.redirect(findURL.getUrl());
        } catch (Exception e) {
            System.out.println("e = " + e.getLocalizedMessage());
        }

        return null;
    }

    /**
     * @return the direccionReporteAcumulaDecimos
     */
    public String getDireccionReporteAcumulaDecimos() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            SegUrls findURL = segUrlsFacade.findURL("reporte acumuladecimos");
            direccionReporteAcumulaDecimos = findURL.getUrl();
        } catch (Exception e) {
            System.out.println("e = " + e.getLocalizedMessage());
        }
        return direccionReporteAcumulaDecimos;
    }

    /**
     * @param direccionReporteAcumulaDecimos the direccionReporteAcumulaDecimos
     * to set
     */
    public void setDireccionReporteAcumulaDecimos(String direccionReporteAcumulaDecimos) {
        this.direccionReporteAcumulaDecimos = direccionReporteAcumulaDecimos;
    }
}
