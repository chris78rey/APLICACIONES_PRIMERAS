/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegUsuario;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }

    public SegUsuario findByCC(String name) {
        return (SegUsuario) em.createQuery(
                "SELECT s FROM SegUsuario s WHERE s.cedulaLogin = :cedulaLogin")
                .setParameter("cedulaLogin", name)
                .setHint("eclipselink.refresh", "true").getSingleResult();
    }

    public String pLogin(String usuario, String clave) throws NamingException, SQLException {
        String pIngresar = "";
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_LOGIN_comun");
//        System.out.println("storedProcedure = " + storedProcedure);
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, usuario);
        storedProcedure.setParameter(2, clave);
        storedProcedure.execute();
        pIngresar = (String) storedProcedure.getOutputParameterValue(3);
        return pIngresar;
    }

    public String p_encript_palabra(String palabra) throws NamingException, SQLException {
        String pEncriptada = "";
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SEGURIDADES.PACK_SEGURIDADES.P_ENCRIPT_PALABRA");
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, palabra);
        storedProcedure.execute();
        pEncriptada = (String) storedProcedure.getOutputParameterValue(2);
        return pEncriptada;
    }


    public String p_decript_palabra(String palabra) throws NamingException, SQLException {
        String pDEcriptada = "";
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SEGURIDADES.PACK_SEGURIDADES.p_decript_palabra");
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, palabra);
        storedProcedure.execute();
        pDEcriptada = (String) storedProcedure.getOutputParameterValue(2);
        return pDEcriptada;
    }

    public String p_envia_mail(String correodestino, String subject, String mensaje, String tipocorreo) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SIS.SEND_MAIL");
        // set parameters
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

        storedProcedure.setParameter(1, correodestino);
        storedProcedure.setParameter(2, subject);
        storedProcedure.setParameter(3, mensaje);
        storedProcedure.setParameter(4, tipocorreo);

        // execute SP
        storedProcedure.execute();
        return null;
    }

}
