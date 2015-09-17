/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OHigieneOralSimplificada;
import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class OHigieneOralSimplificadaFacade extends AbstractFacade<OHigieneOralSimplificada> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OHigieneOralSimplificadaFacade() {
        super(OHigieneOralSimplificada.class);
    }

    public List<OHigieneOralSimplificada> listHigOralSimp(Pacientes pHc) {
        StringBuilder sb = new StringBuilder("select object(o) from OHigieneOralSimplificada as o");
        sb.append(" where o.pacientes = :pacientes");
        sb.append(" ORDER BY o.hosFecha DESC, o.hpdId");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", pHc);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
    }

    public boolean DienteExiste(String existe) {
        BigDecimal count;
        count = (BigDecimal) em.createNativeQuery(existe).getSingleResult();
        if (count.longValue() == 0) {
            return false;
        } else {
            return true;
        }
        //return (BigDecimal) em.createNativeQuery(existe).getSingleResult();
    }

    public List<OHigieneOralSimplificada> findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OHigieneOralSimplificada.class);
        List<OHigieneOralSimplificada> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;

    }

    public List<OHigieneOralSimplificada> findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OHigieneOralSimplificada o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OHigieneOralSimplificada> result = q.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}
