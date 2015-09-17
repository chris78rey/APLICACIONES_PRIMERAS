/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.VUsuariosClasif;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class VUsuariosClasifFacade extends AbstractFacade<VUsuariosClasif> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VUsuariosClasifFacade() {
        super(VUsuariosClasif.class);
    }

    public VUsuariosClasif findByCedulaLogin(String cedula) {
        String CEDCORR = (cedula == null) ? "-1" : cedula;
        return (VUsuariosClasif) em.createQuery("SELECT v FROM VUsuariosClasif v WHERE v.cedulaLogin = :cedulaLogin").setParameter("cedulaLogin", cedula).setHint("eclipselink.refresh", "true").getSingleResult();
    }

    public String findExisteFoto(String pIdUsuario) {
        String sql = "SELECT DBMS_LOB.FILEEXISTS (BFILE_FOTO) existe"
                + "  FROM SEGURIDADES.SEG_USUARIO"
                + " WHERE SEG_USUARIO.ID = " + pIdUsuario;
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = getEntityManager().createNativeQuery(sql);
        Object results = query.getSingleResult();
        return results.toString();

    }
}
