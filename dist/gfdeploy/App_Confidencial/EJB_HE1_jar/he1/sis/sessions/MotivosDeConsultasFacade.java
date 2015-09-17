/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.MotivosDeConsultas;
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
public class MotivosDeConsultasFacade extends AbstractFacade<MotivosDeConsultas> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivosDeConsultasFacade() {
        super(MotivosDeConsultas.class);
    }

    public List<MotivosDeConsultas> listMotivoConsulta(HojasDeEvolucion hojaEvol) {
        StringBuilder sb = new StringBuilder("select object(o) from MotivosDeConsultas as o");
        sb.append(" where o.hojasDeEvolucion = :hojaEvol");
        Query q = em.createQuery(sb.toString());
        q.setParameter("hojaEvol", hojaEvol);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public MotivosDeConsultas findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, MotivosDeConsultas.class);
        List<MotivosDeConsultas> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (MotivosDeConsultas) result.get(0);

    }

    public MotivosDeConsultas findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM MotivosDeConsultas o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<MotivosDeConsultas> l = q.getResultList();
        if (!l.isEmpty()) {
            return (MotivosDeConsultas) l.get(0);
        } else {
            return null;
        }
    }
}
