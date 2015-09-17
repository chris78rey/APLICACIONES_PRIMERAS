/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.mbeans;

import he1.seguridades.entities.SegUrls;
import he1.seguridades.entities.nuevos.CodigoMifinPortal;
import he1.seguridades.entities.nuevos.SegMinisterioFinanzas;
import he1.seguridades.entities.nuevos.TipoRelacionLaboral;
import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.CodigoMifinPortalFacade;
import he1.seguridades.sessions.SegMinisterioFinanzasFacade;
import he1.seguridades.sessions.SegUrlsFacade;
import he1.seguridades.sessions.TipoRelacionLaboralFacade;
import he1.utilities.SesionSeguridades;
import he1.sis.entities.Personal;
import he1.sis.sessions.PersonalFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@ManagedBean(name = "mbpersonal")
@RequestScoped
public class JSFManagedBeanPersonal {

    private String idper = "-1";
    @EJB
    private CodigoMifinPortalFacade codigoMifinPortalFacade;
    private List<CodigoMifinPortal> lcodigoMifinPortal = new ArrayList<CodigoMifinPortal>();
    private CodigoMifinPortal cmp = new CodigoMifinPortal();

    @EJB
    private TipoRelacionLaboralFacade tipoRelacionLaboralFacade;

    @EJB
    private SegMinisterioFinanzasFacade segMinisterioFinanzasFacade;

    @EJB
    private SesionSeguridades sesionSeguridades;

    @EJB
    private PersonalFacade personalFacade;

    @EJB
    private SesionSeguridades encryptFacade;
    @EJB
    private SegUrlsFacade segUrlsFacade;

    private String url;
    private String mes;
    private String anio;
    private String mfinseleccionado;

    public Personal getPersonal() {

        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    Personal personal;

    /**
     * Creates a new instance of JSFManagedBeanPersonal
     */
    public JSFManagedBeanPersonal() {

        personal = new Personal();
    }
    private VUsuariosClasif findByCedulaLogin = new VUsuariosClasif();

    @PostConstruct
    private void init() {
        try {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

            //Ojo se coloca aca este código antes ya que el componenete no siempre coincide que el personal de nomina se encuentre en SIS personal
            //Ojo se coloca aca este código antes ya que el componenete no siempre coincide que el personal de nomina se encuentre en SIS personal
            //Ojo se coloca aca este código antes ya que el componenete no siempre coincide que el personal de nomina se encuentre en SIS personal
            //Ojo se coloca aca este código antes ya que el componenete no siempre coincide que el personal de nomina se encuentre en SIS personal
            //Ojo se coloca aca este código antes ya que el componenete no siempre coincide que el personal de nomina se encuentre en SIS personal            
            findByCedulaLogin = ((VUsuariosClasif) session.getAttribute("vUsuariosClasif"));
            lcodigoMifinPortal = codigoMifinPortalFacade.findCodigosPersonalNomina(findByCedulaLogin.getNomId());

        } catch (Exception e) {
        }

    }

    public String logout() throws IOException {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            Enumeration<String> attributeNames = session.getAttributeNames();
            String nextElement = "";
            while (attributeNames.hasMoreElements()) {
                try {
                    nextElement = attributeNames.nextElement();
                    session.removeAttribute(nextElement);
                } catch (Exception e) {
                }
            }
            session = null;
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(sesionSeguridades.getPresionarSalir());
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @return the url
     */
    public String getUrl() {
        try {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       
        

            CodigoMifinPortal codigoMifinPortal = codigoMifinPortalFacade.find(new BigDecimal(idper));

            SegMinisterioFinanzas segMinisterioFinanzas = new SegMinisterioFinanzas();

//            this.url = "https://spryn.finanzas.gob.ec/birt/frameset?__report=MF_ESIPREN2_PRO_PROCESOS_NOMINA_RESULTADOS_ROL_PAGOS.rptdesign&p_ef=2015&p_ins=HOSPITAL%20DE%20ESPECIALIDADES%20FUERZAS%20ARMADAS%20NO.%201&p_usu=JAVIERCUARAN&p_mes=FEBRERO&p_procesoNomina=4509685&p_tipoDocumento=C&p_numeroDocumento=" + personal.getCedula().toString();
            this.url = "https://spryn.finanzas.gob.ec/birt/"
                    + "frameset?__report=MF_ESIPREN2_PRO_PROCESOS_NOMINA_RESULTADOS_ROL_PAGOS."
                    + "rptdesign&p_ef=" + codigoMifinPortal.getAnio() + "&p_ins=HOSPITAL%20DE%20ESPECIALIDADES%20FUERZAS%20ARMADAS%20NO.%201"
                    + "&p_usu=JAVIERCUARAN&p_mes=" + codigoMifinPortal.getMes() + "&p_procesoNomina=" + codigoMifinPortal.getCodigo()
                    + "&p_tipoDocumento=C&p_numeroDocumento=" + codigoMifinPortal.getCedula();
            System.out.println("url = " + url);
        } catch (Exception e) {

        }
        return url;

    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {

        this.url = url;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        System.out.println("mes = " + mes);
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        System.out.println("anio = " + anio);
        this.anio = anio;
    }
    private SegMinisterioFinanzas ministerioFinanzas = new SegMinisterioFinanzas();
    private List<SegMinisterioFinanzas> findPersonalCriterios;

    /**
     * @return the findPersonalCriterios
     */
    public List<SegMinisterioFinanzas> getFindPersonalCriterios() {

        String tipoContratoPersonal = getTipoContratoPersonal();

        //esto se coloca en el Managed Bean  
        TipoRelacionLaboral laboral = new TipoRelacionLaboral();
        laboral = tipoRelacionLaboralFacade.find(new BigDecimal(tipoContratoPersonal));
//        findPersonalCriterios = segMinisterioFinanzasFacade.findPersonalCriterios();
        findPersonalCriterios = segMinisterioFinanzasFacade.findPersonalCriteriosporPersonal(laboral);
        return findPersonalCriterios;
    }

    List<Map> listabuscaautocomplete = new ArrayList<>();

    public String getTipoContratoPersonal() {
        Object mfi = "";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        String usuarioDB = (String) session.getAttribute("usuarioDB");
        personal = personalFacade.find(usuarioDB);
        String data = "";
        data = segMinisterioFinanzasFacade.BuscaAutoComplete(personal.getCodigo());

        return data;
    }

    /**
     * @return the mfinseleccionado
     */
    public String getMfinseleccionado() {
        return mfinseleccionado;
    }

    /**
     * @param mfinseleccionado the mfinseleccionado to set
     */
    public void setMfinseleccionado(String mfinseleccionado) {
        try {

            ministerioFinanzas = segMinisterioFinanzasFacade.find(new BigDecimal(mfinseleccionado));
        } catch (Exception e) {
        }
        this.mfinseleccionado = mfinseleccionado;
    }

    /**
     * @return the ministerioFinanzas
     */
    public SegMinisterioFinanzas getMinisterioFinanzas() {
        return ministerioFinanzas;
    }

    /**
     * @param ministerioFinanzas the ministerioFinanzas to set
     */
    public void setMinisterioFinanzas(SegMinisterioFinanzas ministerioFinanzas) {
        this.ministerioFinanzas = ministerioFinanzas;
    }

    /**
     * @return the findByCedulaLogin
     */
    public VUsuariosClasif getFindByCedulaLogin() {
        return findByCedulaLogin;
    }

    /**
     * @param findByCedulaLogin the findByCedulaLogin to set
     */
    public void setFindByCedulaLogin(VUsuariosClasif findByCedulaLogin) {
        this.findByCedulaLogin = findByCedulaLogin;
    }

    public String regresaMenuPortal() throws IOException {
        String usuId = encryptFacade.encyrpDinamico(findByCedulaLogin.getCedulaLogin());
        SegUrls findURL = segUrlsFacade.findURL("menu del portal");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(findURL.getUrl() + usuId);
        return null;
    }

    /**
     * @return the lcodigoMifinPortal
     */
    public List<CodigoMifinPortal> getLcodigoMifinPortal() {
        return lcodigoMifinPortal;
    }

    /**
     * @return the cmp
     */
    public CodigoMifinPortal getCmp() {
        return cmp;
    }

    /**
     * @param cmp the cmp to set
     */
    public void setCmp(CodigoMifinPortal cmp) {
        this.cmp = cmp;
    }

    /**
     * @return the idper
     */
    public String getIdper() {
        return idper;
    }

    /**
     * @param idper the idper to set
     */
    public void setIdper(String idper) {
        System.out.println("idper = " + idper);
        this.idper = idper;
    }

}
